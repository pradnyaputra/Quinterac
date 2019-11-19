import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The Back End of the Quinterac ATM system
 */
public class BackEnd {
	private static String oldMasterAccountsFile = "oldMasterAccounts.txt";
	private static String mergedTransactionSummaryFile = "mergedTransactionSummaryFile.txt";
	private static HashMap<String, Account> accounts = new HashMap<String, Account>();

	public static void main(String[] args) {
		if (args.length == 2) {
			// capture the arguments passed in from the commandline
			oldMasterAccountsFile = args[0];
			mergedTransactionSummaryFile = args[1];
		} else {
		    System.out.println("This program has to be passed two file locations.");
		    System.out.println("Please specify the location of the Old Master Accounts File," +
                    " and the Merged Transaction Summary File");
        }

        //check whether the input files are valid or not
        inputFileValidity(mergedTransactionSummaryFile, oldMasterAccountsFile);

		accounts = readOldMasterAccountsFile(oldMasterAccountsFile);
		processMergedTransactions(mergedTransactionSummaryFile);

		// creates a new master account file
		try {
			newMasterAcctFile();
		} catch (IOException e) {
			System.out.println("ERROR: " + e);
		}

		// creates a new valid account list file
		try {
			newValidAccList();
		} catch (IOException e) {
			System.out.println("ERROR: " + e);
		}
	}

    /**
     * Check to ensure that daily limit has not been exceeded
     * @param amount The amount currently being processed
     * @param command The command being processed
     * @param accountNum The account number to check
     * @param transactions An array of all previous transactions up to the current point of processing
     * @return true if the account is over the daily limit, false otherwise
     */
	private static boolean overDailyLimit(int amount, String command, String accountNum, ArrayList<String> transactions) {
		Account temp = accounts.get(accountNum);

		int dailyDepositLimit = 5000;
		int dailyWithdrawLimit = 5000;
		int dailyTransferLimit = 10000;

		for (int i = 0; i < transactions.size(); i++) {
			String[] words = transactions.get(i).split(" ");
			if (words[1].equals(temp.getAccountID()) && String.join(" ", Arrays.copyOfRange(words, 2, words.length)).equals(temp.getAccountName())) {
				if (words[0].equals("DEP"))
					dailyDepositLimit -= Integer.parseInt(words[2]);
				else if (words[0].equals("WDR"))
					dailyWithdrawLimit -= Integer.parseInt(words[2]);
				else if (words[0].equals("XFR"))
					dailyTransferLimit -= Integer.parseInt(words[2]);
			}
		}

		if (command.equals("DEP")) {
			if (dailyDepositLimit - amount < 0) {
				System.out.println("Daily deposit limit is $5000 per amount!");
				return true;
			}
		} else if (command.equals("WDR")) {
			if (dailyWithdrawLimit - amount < 0) {
				System.out.println("Daily withdraw limit is $5000 per amount!");
				return true;
			}
		} else if (command.equals("XFR")) {
			if (dailyTransferLimit - amount < 0) {
				System.out.println("Daily transfer limit is $10000 per amount!");
				return true;
			}
		}
		return false;
	}

    /**
     * Create an Account instance for every account in the old master accounts file
     * @param filename Old Master Accounts file location
     * @return A map with account name as key and Account object as value
     */
	private static HashMap<String, Account> readOldMasterAccountsFile(String filename) {
		HashMap<String, Account> temp = new HashMap<String, Account>();
		Scanner file = null;
		try {
			file = new Scanner(new FileInputStream(filename));

			while (file.hasNextLine()) {
				String line = file.nextLine();
				// values are separated by space
				String[] words = line.split(" ");
				// the copyOfRange method is used to ensure that names with spaces in them are taken as a whole
				Account tempAccount = new Account(words[0], Integer.parseInt(words[1]),
						String.join(" ", Arrays.copyOfRange(words, 2, words.length)));
				temp.put(words[0], tempAccount);
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return temp;
	}

    /**
     * Process all the transactions passed in at the end of the day
     * @param filename The Merged Transaction Summary File location
     */
	private static void processMergedTransactions(String filename) {
	    // this is used to store previous lines as we go, so we can check daily limit amounts
        // it is a bit arbitrary but we don't have timestamps on these transactions so it's the best we can do
		ArrayList<String> transactions = new ArrayList<String>();
		Scanner file = null;
		try {
			file = new Scanner(new FileInputStream(filename));

			while (file.hasNextLine()) {
				String line = file.nextLine();
				String[] words = line.split(" ");
				String command = words[0];
				String accountFrom = words[1];
				int amount = Integer.parseInt(words[2]);
				String accountTo = words[3];
				String accountName = words[4];

				switch (command) {
					case "NEW":
						createAcct(accountFrom, accountName);
						break;
					case "DEP":
						if (!overDailyLimit(amount, command, accountFrom, transactions)) {
							deposit(accountFrom, amount, accountName);
							// this was a deposit line, so add it to the list of previous transactions
							transactions.add(line);
						}
						break;
					case "WDR":
						if (!overDailyLimit(amount, command, accountFrom, transactions)) {
							withdraw(accountFrom, amount, accountName);
                            // this was a withdraw line, so add it to the list of previous transactions
							transactions.add(line);
						}
						break;
					case "XFR":
						if (!overDailyLimit(amount, command, accountFrom, transactions)) {
							transfer(accountFrom, amount, accountTo);
                            // this was a transfer line, so add it to the list of previous transactions
							transactions.add(line);
						}
						break;
					case "DEL":
						deleteAcct(accountFrom, accountName);
						break;
					case "EOS":
						break;
					default:
					    // We couldn't process this line, it had a bad command, print it to the "error" log
						System.out.println(line);
				}
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

    /**
     * Delete an account
     * @param accountNumber The account number of the account to be deleted
     * @param accountName The account name, to ensure that the command is for the right account
     */
	private static void deleteAcct(String accountNumber, String accountName) {
		Account tempAccount = accounts.get(accountNumber);
		if (!tempAccount.getAccountName().equals(accountName)) {
			System.out.println("Error, name does not match");
			System.out.println("should be " + accountName + tempAccount.getAccountName());
			return;
		}
		accounts.remove(accountNumber);
	}

    /**
     * Perform transfer command
     * @param accountNumberFrom Account number money will be taken from
     * @param amount The amount to transfer
     * @param accountNumberTo Account number money will be transferred to
     */
	private static void transfer(String accountNumberFrom, int amount, String accountNumberTo) {
		Account fromAccount = accounts.get(accountNumberFrom);
		Account toAccount = accounts.get(accountNumberTo);

		if (fromAccount.getBalance() - amount < 0) {
			System.out.println("Negative balance");
		} else {
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);
		}
	}

    /**
     * Perform withdraw command
     * @param accountNumber Account number to withdraw from
     * @param amount The amount to withdraw
     * @param accountName The account name, to ensure that the command is for the right account
     */
	private static void withdraw(String accountNumber, int amount, String accountName) {
		Account tempAccount = accounts.get(accountNumber);
		if (!tempAccount.getAccountName().equals(accountName)) {
			System.out.println("Error, name does not match");
			return;
		}
		if (tempAccount.getBalance() - amount < 0) {
			System.out.println("Negative balance");
		} else {
			tempAccount.setBalance(tempAccount.getBalance() - amount);
		}
	}

    /**
     * Perform deposit command
     * @param accountNumber Account number to receive deposit
     * @param amount The amount to deposit
     * @param accountName The account name, to ensure that the command is for the right account
     */
	private static void deposit(String accountNumber, int amount, String accountName) {
		Account tempAccount = accounts.get(accountNumber);
		if (!tempAccount.getAccountName().equals(accountName)) {
			System.out.println("Error, name does not match");
			return;
		}
		tempAccount.setBalance(amount + tempAccount.getBalance());
	}

    /**
     * Create an account
     * @param accountNumber The account number to create
     * @param accountName The account name for the account to be created
     */
	private static void createAcct(String accountNumber, String accountName) {
		Account tempAccount = new Account(accountNumber, 0, accountName);
		accounts.put(accountNumber, tempAccount);
	}

	private static void inputFileValidity(String tsf, String maf) {
		if (Validation.isMafValid(maf)) {
			if (Validation.isTsfValid(tsf))
				return;
		}
		System.out.println("FATAL ERROR: Input file validity check failed.");
		System.exit(1);
	}



	private static void newMasterAcctFile() throws IOException {
		//Creating the new Master Accounts File, and creating a set of all keys
		BufferedWriter writer = new BufferedWriter(new FileWriter("NewMasterAccountsFile.txt"));

		Set<Integer> intKeySet = accounts.keySet().stream()
				.map(s -> Integer.parseInt(s))
				.collect(Collectors.toSet());

		int[] keyArray = new int[intKeySet.size()];

		//converting keySet to array to prepare for sorting
		int count = 0;
		for (int key : intKeySet)
			keyArray[count++] = key;

		//for loop to sort the keys in descending order
		for (int i = 0; i < keyArray.length; i++) {
			for (int j = 0; j < keyArray.length; j++) {
				if (keyArray[j] < keyArray[i]) {
					int temp = keyArray[i];
					keyArray[i] = keyArray[j];
					keyArray[j] = temp;
				}
			}
		}

		//for loop to ensure all accounts from hashset are added to new Master Account File
		for (int i = 0; i < keyArray.length; i++) {
			Account acc = accounts.get(Integer.toString(keyArray[i]));
			writer.write(keyArray[i] + " " + acc.getBalance() + " " + acc.getAccountName());
			writer.newLine();
		}

		writer.close();
	}

	private static void newValidAccList() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("newValidAccList.txt"));
		for (Map.Entry<String, Account> entry : accounts.entrySet()) {
			writer.write(entry.getKey());
			writer.newLine();
		}
		writer.write("0000000");
		writer.newLine();
		writer.close();
	}
}