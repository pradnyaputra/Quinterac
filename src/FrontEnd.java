import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FrontEnd {

	private static Queue<String> tsfQueue = new LinkedList<>();
	private static boolean loggedOut = true;
	private static String accountListFileLocation = "";
	private static String transactionSummaryFileLocation = "";

	public static void main(String[] args) {
		if (args.length == 2) {
			// capture the arguments passed in from the commandline
			accountListFileLocation = args[0];
			transactionSummaryFileLocation = args[1];
		} else {
			System.out.println("Please specify the locations of the account list txt file and the transaction summary txt file");
			return;
		}
		startUp();
	}

	private static void startUp() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Quinterac, developed by YES-MEN");
		System.out.println("Please enter 'login' to begin using the service");
		while (!input.nextLine().equals("login")) {
			System.out.println("The only valid command is login");
		}
		boolean agent = login();
		while (!loggedOut) {
			switch (input.nextLine()) {
				case "logout":
					logout();
					break;
				case "createacct":
					createAcct(agent);
					break;
				case "deleteacct":
					deleteacct(agent);
					break;
				case "deposit":
					deposit(agent);
					break;
				case "withdraw":
					withdraw(agent);
					break;
				case "transfer":
					transfer(agent);
					break;
				default:
					System.out.println("Please enter one of the commands as input");
			}
		}
	}

	private static boolean login() {
		System.out.println("Do you want a machine or agent session?");
		Scanner input = new Scanner(System.in);
		boolean agent;
		String sessionType = input.nextLine();
		while (!sessionType.equals("machine") && !sessionType.equals("agent")) {
			System.out.println("The only valid options are 'machine' or 'agent'");
			sessionType = input.nextLine();
		}
		agent = sessionType.equals("agent");
		loggedOut = false;
		System.out.println("Logged in");
		return agent;
	}

	private static void logout() {
		System.out.println("The session has been closed for the day");
		String endOfSession = "EOS";
		tsfQueue.add(endOfSession);
		try {
			writeTransactionsToSummaryFile("transactionSummaryFile.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		loggedOut = true;
		startUp();
	}

	private static void createAcct(boolean agent) {
		Scanner input = new Scanner(System.in);

		String accName;
		String accNum;
		String tsfData;
		if (!agent) {
			System.out.println("Please use agent mode to access this command.");
			return;
		} else {
			System.out.println("Please enter the new account number: ");
			accNum = input.nextLine();

			if (accountNumberValid(accNum) && !accountNumberExists(accNum)) {
				System.out.println("Please enter an account name: ");
				accName = input.nextLine();

				if (accountNameValid(accName)) {
					tsfData = "NEW " + accNum + " 000 0000000 " + accName;
					tsfQueue.add(tsfData);
					System.out.println("Account created successfully");
					return;
				} else {
					System.out.println("Invalid account name");
					return;
				}
			} else {
				System.out.println("invalid account number");
				return;
			}
		}

	}

	private static void deleteacct(boolean agent) {
		Scanner input = new Scanner(System.in);
		String accName;
		String accNum;
		String tsfData;

		if (!agent) {
			System.out.println("Please use agent mode to access this command.");
			return;
		} else {
			System.out.println("Please enter the your account number: ");
			accNum = input.nextLine();

			if (accountNumberValid(accNum) && accountNumberExists(accNum)) {
				System.out.println("Please enter your account name: ");
				accName = input.nextLine();

				if (accountNameValid(accName)) {
					tsfData = "DEL " + accNum + " 000 0000000 " + accName;
					tsfQueue.add(tsfData);
					System.out.println("Account successfully deleted");
					return;
				} else {
					System.out.println("Invalid account name");
					return;
				}
			} else {
				System.out.println("invalid account number");
				return;
			}
		}
	}

	private static void deposit(boolean agent) {
		Scanner input = new Scanner(System.in);
		String amount;
		String accNum;
		String tsfData;

		System.out.println("Please enter the your account number: ");
		accNum = input.nextLine();

		if (accountNumberValid(accNum) && accountNumberExists(accNum)) {
			System.out.println("Please enter the amount you wish to deposit: ");
			amount = input.nextLine();

			if (isAllDigits(amount)) {
				if (agent) {
					if (Integer.parseInt(amount) >= 0 && Integer.parseInt(amount) <= 99999999) {
						tsfData = "DEP " + accNum + " " + amount + " 0000000 ***";
						tsfQueue.add(tsfData);
						System.out.println("Amount successfully deposited");
						return;
					} else {
						System.out.println("Error: Invalid amount");
						return;
					}
				} else {// machine mode
					if (Integer.parseInt(amount) >= 0 && Integer.parseInt(amount) <= 200000) {
						int dailyTotal = 0;
						for (int i = 0; i < tsfQueue.size(); i++) {
							String queueVal = tsfQueue.poll();
							String[] queueValArr = queueVal.split(" ");
							if (queueValArr[0].equals("WDR") && queueValArr[1].equals(accNum)) {
								dailyTotal += Integer.parseInt(queueValArr[2]);
							}
							tsfQueue.add(queueVal);
						}
						if ((dailyTotal + Integer.parseInt(amount)) > 500000) {
							System.out.println("ERROR: Can’t deposit more than $5000 in one day in ATM mode");
							return;
						} else {
							tsfData = "DEP " + accNum + " " + amount + " 0000000 ***";
							tsfQueue.add(tsfData);
							System.out.println("Amount successfully deposited");
							return;
						}
					} else {
						System.out.println("ERROR: Invalid amount");
						return;
					}
				}

			} else {
				System.out.println("ERROR: Invalid account name");
				return;
			}
		} else {
			System.out.println("ERROR: Invalid account number");
			return;
		}
	}

	private static void withdraw(boolean agent) {
		Scanner input = new Scanner(System.in);
		String amount;
		String accNum;
		String tsfData;

		System.out.println("Please enter the your account number: ");
		accNum = input.nextLine();

		if (accountNumberValid(accNum) && accountNumberExists(accNum)) {
			System.out.println("Please enter the amount you wish to withdraw in cents: ");
			amount = input.nextLine();

			if (isAllDigits(amount)) {
				if (agent) {
					if (Integer.parseInt(amount) >= 0 && Integer.parseInt(amount) <= 99999999) {
						tsfData = "WDR 0000000 " + amount + " " + accNum + " ***";
						tsfQueue.add(tsfData);
						System.out.println("Amount successfully withdrawn");
						return;
					} else {
						System.out.println("ERROR: Please enter a valid value");
						return;
					}
				} else {// machine mode
					if (Integer.parseInt(amount) >= 0 && Integer.parseInt(amount) <= 100000) {
						int dailyTotal = 0;
						for (int i = 0; i < tsfQueue.size(); i++) {
							String queueVal = tsfQueue.poll();
							String[] queueValArr = queueVal.split(" ");
							if (queueValArr[0].equals("WDR") && queueValArr[3].equals(accNum)) {
								dailyTotal += Integer.parseInt(queueValArr[2]);
							}
							tsfQueue.add(queueVal);
						}
						if ((dailyTotal + Integer.parseInt(amount)) > 500000) {
							System.out.println("ERROR: Can’t withdraw more than $5000 in one day in ATM mode");
							return;
						} else {
							tsfData = "WDR 0000000 " + amount + " " + accNum + " 0000000 ***";
							tsfQueue.add(tsfData);
							System.out.println("Amount successfully withdrawn");
							return;
						}
					} else {
						System.out.println("ERROR: Invalid amount");
						return;
					}
				}

			} else {
				System.out.println("ERROR Invalid account name");
				return;
			}
		} else {
			System.out.println("ERROR: Invalid account number");
			return;
		}

	}

	private static void transfer(boolean agent) {
		Scanner input = new Scanner(System.in);
		String amount;
		String accNumFrom;
		String accNumTo;
		String tsfData;

		System.out.println("Please enter the account number you want to transfer from: ");
		accNumFrom = input.nextLine();
		System.out.println("Please enter the account you want to transfer to: ");
		accNumTo = input.nextLine();


		if (accountNumberValid(accNumTo) && accountNumberExists(accNumTo) && accountNumberValid(accNumFrom) && accountNumberExists(accNumFrom)) {
			System.out.println("Please enter the amount you wish to transfer in cents: ");
			amount = input.nextLine();

			if (isAllDigits(amount)) {
				if (agent) {
					if (Integer.parseInt(amount) >= 0 && Integer.parseInt(amount) <= 99999999) {
						tsfData = "XFR " + accNumTo + " " + amount + " " + accNumFrom + " ***";
						tsfQueue.add(tsfData);
						System.out.println("Amount successfully transferred");
						return;
					} else {
						System.out.println("ERROR: Please enter a valid value");
						return;
					}
				} else {// machine mode
					if (Integer.parseInt(amount) >= 0 && Integer.parseInt(amount) <= 1000000) {
						int dailyTotal = 0;
						for (int i = 0; i < tsfQueue.size(); i++) {
							String queueVal = tsfQueue.poll();
							String[] queueValArr = queueVal.split(" ");
							if (queueValArr[0].equals("WDR") && queueValArr[1].equals(accNumFrom)) {
								dailyTotal += Integer.parseInt(queueValArr[2]);
							}
							tsfQueue.add(queueVal);
						}
						if ((dailyTotal + Integer.parseInt(amount)) > 1000000) {
							System.out.println("ERROR: Can’t transfer more than $10000 in one day in ATM mode");
							return;
						} else {
							tsfData = "XFR " + accNumTo + " " + amount + " " + accNumFrom + " ***";
							tsfQueue.add(tsfData);
							System.out.println("Amount successfully transferred");
							return;
						}
					} else {
						System.out.println("ERROR: Invalid amount");
						return;
					}
				}

			} else {
				System.out.println("ERROR Invalid account name");
				return;
			}
		} else {
			System.out.println("ERROR: Invalid account number");
		}

	}

	/*
	 * Common helper functions
	 */

	private static boolean isAllDigits(String number) {
		for (Character x : number.toCharArray()) {
			if (!Character.isDigit(x)) {
				return false;
			}
		}
		return true;
	}

	private static boolean accountNumberValid(String number) {
		// new account number is exactly seven decimal digits not beginning with 0
		// (e.g., 1234567)
		number = number.trim();
		if (!isAllDigits(number)) {
			return false;
		}

		if (number.length() != 7) {
			return false;
		}

		return number.charAt(0) != '0';

	}

	private static boolean accountNumberExists(String number) {
		Scanner file = null;
		try {
			file = new Scanner(new FileInputStream("validAccountList.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: " + e.getMessage());
		}


		while (file.hasNextLine()) {
			String line = file.nextLine();
			if (line.equals(number)) {
				return true;
			}
		}
		file.close();
		return false;

	}

	private static boolean accountNameValid(String name) {

		return (name.matches("[a-zA-Z0-9]+"))
				&& (name.length() <= 30)
				&& (name.length() >= 3)
				&& !((name.charAt(0) == ' ')
				&& name.charAt(name.length() - 1) == ' ');

	}

	private static void writeTransactionsToSummaryFile(String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		while (!tsfQueue.isEmpty()) {
			writer.write(tsfQueue.poll());
			writer.newLine();
		}
		writer.close();
	}
}
