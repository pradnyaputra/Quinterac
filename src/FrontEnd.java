import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FrontEnd {

	private static Queue<String> tsfQueue = new LinkedList<>();
	private static boolean loggedOut = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		startUp();
	}

	public static void startUp() {
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
					deposit();
					break;
				case "withdraw":
					withdraw(agent);
					break;
				case "transfer":
					transfer();
					break;
				default:
					System.out.println("Please enter one of the commands as input");
			}
		}
	}

	public static boolean login() {
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

	public static void logout() {
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

	public static String createAcct(boolean agent) {
		Scanner input = new Scanner(System.in);

		String accName;
		String accNum;
		String tsfData;
		if (!agent) {
			return "Please use agent mode to access this command.";
		} else {
			System.out.println("Please enter the new account number: ");
			accNum = input.nextLine();

			if (accountNumberValid(accNum) && !accountNumberExists(accNum)) {
				System.out.println("Please enter an account name: ");
				accName = input.nextLine();

				if (accountNameValid(accName)) {
					tsfData = "NEW " + accNum + " 000 0000000 " + accName;
					tsfQueue.add(tsfData);
					return "Account created successfully";
				} else {
					return "Invalid account name";
				}
			} else {
				return "invalid account number";
			}
		}

	}

	public static String deleteacct(boolean agent) {
		Scanner input = new Scanner(System.in);
		String accName;
		String accNum;
		String tsfData;

		if (!agent) {
			return "Please use agent mode to access this command.";
		} else {
			System.out.println("Please enter the your account number: ");
			accNum = input.nextLine();

			if (accountNumberValid(accNum) && accountNumberExists(accNum)) {
				System.out.println("Please enter your account name: ");
				accName = input.nextLine();

				if (accountNameValid(accName)) {
					tsfData = "DEL " + accNum + " 000 0000000 " + accName;
					tsfQueue.add(tsfData);
					return "Account successfully deleted";
				} else {
					return "Invalid account name";
				}
			} else {
				return "invalid account number";
			}
		}
	}

	public static void deposit() {
		System.out.println("deposit");
	}

	public static String withdraw(boolean agent) {
		Scanner input = new Scanner(System.in);
		String accAmount;
		String accNum;
		String tsfData;

		System.out.println("Please enter the your account number: ");
		accNum = input.nextLine();

		if (accountNumberValid(accNum) && accountNumberExists(accNum)) {
			System.out.println("Please enter the amount you wish to withdraw: ");
			accAmount = input.nextLine();

			if (isAllDigits(accAmount)) {
				if (agent) {
					if (Integer.parseInt(accAmount) >= 0 && Integer.parseInt(accAmount) <= 999999.99) { // if out of
						// bounds then
						// throw error
						// message
						return "Error: Please enter a valid value";
					} else {
						tsfData = "WDR " + accNum + " " + accAmount + " 0000000 ***";
						tsfQueue.add(tsfData);
						return "Amount successfully withdrawn";
					}
				} else {// machine mode
					if (Integer.parseInt(accAmount) >= 0 && Integer.parseInt(accAmount) <= 1000) { // if out of bounds
						// then throw error
						// working out current daily limit
						int dailyTotal = 0;
						for (int i = 0; i < tsfQueue.size(); i++) {
							String queueVal = tsfQueue.poll();
							String[] queueValArr = queueVal.split(" ");
							if (queueValArr[0].equals("WDR") && queueValArr[1].equals(accNum)) {
								dailyTotal += Integer.parseInt(queueValArr[2]);
							}
							tsfQueue.add(queueVal);
						}
						if ((dailyTotal + Integer.parseInt(accAmount)) > 5000) {
							return "Error: Can’t withdraw more than $5000 in one day in ATM mode";
						} else {
							tsfData = "WDR " + accNum + " " + accAmount + " 0000000 ***";
							tsfQueue.add(tsfData);
							return "Amount successfully withdrawn";
						}
					} else {
						return "invalid amount";
					}
				}

			} else {
				return "Invalid account name";
			}
		} else {
			return "invalid account number";
		}

	}

	public static void transfer() {
		System.out.println("transfer");
	}

	/*
	 * Common helper functions
	 */

	public static boolean isAllDigits(String number) {
		for (Character x : number.toCharArray()) {
			if (!Character.isDigit(x)) {
				return false;
			}
		}
		return true;
	}

	public static boolean accountNumberValid(String number) {
		// new account number is exactly seven decimal digits not beginning with 0
		// (e.g., 1234567)
		number = number.trim();
		if (!isAllDigits(number)) {
			return false;
		}

		if (number.length() != 7) {
			return false;
		}

		if (number.charAt(0) == '0') {
			return false;
		}

		return true;

	}

	public static boolean accountNumberExists(String Num) {
		// i only put a return so it would stop screaming error
		// also doesnt exist if delete cmd for account number found in queue
		return true;
	}

	public static boolean accountNameValid(String Name) {
		// i only put a return so it would stop screaming error
		return true;
	}

	public static void writeTransactionsToSummaryFile(String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		while (!tsfQueue.isEmpty()) {
			writer.write(tsfQueue.poll());
			writer.newLine();
		}
		writer.close();
	}

}
