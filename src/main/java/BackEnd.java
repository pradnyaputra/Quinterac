/**
 * Created by Tyler D.S. Elliott on 06-Nov-19.
 */

import java.io.*;
import java.util.HashMap; // import the HashMap class
import java.util.*;


public class BackEnd {
	private static String oldMasterAccountsFile = "";
    private static String mergedTransactionSummaryFile = "";
	private static HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();
    
	
	public static void main(String[] args) {
		if (args.length == 2) {
            // capture the arguments passed in from the commandline
			oldMasterAccountsFile = args[0];
            mergedTransactionSummaryFile = args[1];
        } 
		accounts = readOldMasterAccountsFile(oldMasterAccountsFile);
		processMergedTransactions(mergedTransactionSummaryFile);
		
		for (Integer i : accounts.keySet()) {
			  System.out.println("key: " + i + " value: " + accounts.get(i).getBalance() + " " + accounts.get(i).getAccountName() );
		}

		try{
			newMasterAcctFile();
		}catch (IOException e){
			System.out.println("ERROR: "+e);
		}
	}
	
	public static HashMap<Integer, Account> readOldMasterAccountsFile(String filename) {
		HashMap<Integer, Account> temp = new HashMap<Integer, Account>();
		Scanner file = null;
        try {
            file = new Scanner(new FileInputStream(filename));
            //while loop to ensure all lines are read within the file

            while (file.hasNextLine()) {
                String line = file.nextLine();
                String words[] = line.split(" ");
                Account tempAccount = new Account(Integer.parseInt(words[0]), Integer.parseInt(words[1]), words[2]);
                temp.put(Integer.parseInt(words[0]), tempAccount);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return temp;
	}
	
	public static void processMergedTransactions(String filename) {
		Scanner file = null;
        try {
            file = new Scanner(new FileInputStream(filename));
            //while loop to ensure all lines are read within the file

            while (file.hasNextLine()) {
                String line = file.nextLine();
                String words[] = line.split(" ");
                //adds every account number from the valid account list file to the hashset
                switch (words[0]) {
	                case "NEW":
	                    createAcct(Integer.parseInt(words[1]), words[4]);
	                    break;
	                case "DEP":
	                	deposit(Integer.parseInt(words[1]), Integer.parseInt(words[2]), words[4]);
	                	break;
	                case "WDR":
	                	withdraw(Integer.parseInt(words[1]), Integer.parseInt(words[2]), words[4]);
	                    break;
	                case "XFR":
	                	transfer(Integer.parseInt(words[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]));
	                	break;
	                case "DEL":
	                    deleteAcct(Integer.parseInt(words[1]), words[4]);
	                    break;
	                case "EOS":
	                	break;
	                default:
	                    System.out.println(line);
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
		
	}

	private static void deleteAcct(int accountNumber, String accountName) {
		Account tempAccount = accounts.get(accountNumber); 
		if (!tempAccount.getAccountName().equals(accountName)) {
			System.out.println("Error, name does not match");
			System.out.println("should be " + accountName + tempAccount.getAccountName());
			return;
		}
		accounts.remove(accountNumber);
		
	}

	private static void transfer(int accountNumberFrom, int amount, int accountNumberTo) {
		Account fromAccount = accounts.get(accountNumberFrom); 
		Account toAccount = accounts.get(accountNumberTo); 
		
		if (fromAccount.getBalance() - amount < 0) {
			System.out.println("Negative balance");
		}
		else {
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);
		}
		
	}

	private static void withdraw(int accountNumber, int amount, String accountName) {
		Account tempAccount = accounts.get(accountNumber); 
		if (!tempAccount.getAccountName().equals(accountName)) {
			System.out.println("Error, name does not match");
			return;
		}
		if (tempAccount.getBalance() - amount < 0) {
			System.out.println("Negative balance");
		}
		else {
			tempAccount.setBalance(tempAccount.getBalance() - amount);
		}
	}

	private static void deposit(int accountNumber, int amount, String accountName) {
		Account tempAccount = accounts.get(accountNumber); 
		if (!tempAccount.getAccountName().equals(accountName)) {
			System.out.println("Error, name does not match");
			return;
		}
		tempAccount.setBalance(amount + tempAccount.getBalance());
	}

	private static void createAcct(int accountNumber, String accountName) {
		Account tempAccount = new Account(accountNumber, 0, accountName);
		accounts.put(accountNumber, tempAccount);
	}

	private static void newMasterAcctFile()throws IOException{
		//Creating the new Master Accounts File, and creating a set of all keys
		BufferedWriter writer = new BufferedWriter(new FileWriter("NewMasterAccountsFile.txt"));
		Set <Integer> keySet = accounts.keySet();

		int keyArray[] = new int[keySet.size()];

		//converting keySet to array to prepare for sorting
		int count = 0;
		for (int key : keySet)
			keyArray[count++] = key;

		//for loop to sort the keys in descending order
		for(int i=0;i<keyArray.length;i++){
			for(int j=0; j<keyArray.length;j++){
				if(keyArray[j]<keyArray[i]){
					int temp = keyArray[i];
					keyArray[i]=keyArray[j];
					keyArray[j] = temp;
				}
			}
		}

		//for loop to ensure all accounts from hashset are added to new Master Account File
		for(int i=0;i<keyArray.length;i++) {
			Account acc = accounts.get(keyArray[i]);
			writer.write(keyArray[i]+" "+acc.getBalance()+" "+acc.getAccountName());
			writer.newLine();
		}

		writer.close();
	}
}
