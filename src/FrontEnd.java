
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

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
		while(!input.nextLine().equals("login")) {
			System.out.println("The only valid command is login");
		}
		boolean agent = login();
		while(!loggedOut) {
			switch (input.nextLine()) {
				case "logout":
					logout();
					break;
				case "createacct":
					createAcct(agent);
					break;
				case "deleteacct":
					deleteacct();
					break;
				case "deposit":
					deposit();
					break;
				case "withdraw":
					withdraw();
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

				if (accountNameCheck(accName)) {
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

	public static void deleteacct() {
		System.out.println("deleteacct");
	}

	public static void deposit() {
		System.out.println("deposit");
	}

	public static void withdraw() {
		System.out.println("withdraw");
	}


	public static void transfer() {
		System.out.println("transfer");
	}

	/*
	* Common helper functions
	* */

	public static boolean isAllDigits(String number) {
		for(Character x: number.toCharArray()) {
			if (!Character.isDigit(x)) {
				return false;
			}
		}
		return true;
	}

	public static boolean accountNumberValid(String number) {
		// new account number is exactly seven decimal digits not beginning with 0 (e.g., 1234567)
		number = number.trim();
		if (!isAllDigits(number)) {
			return false;
		}

		if(number.length() != 7) {
			return false;
		}

		if(number.charAt(0) == '0') {
			return false;
		}

		return true;

	}

	public static boolean accountNumberExists(String Num) {
		// i only put a return so it would stop screaming error
		return false;
	}

	public static boolean accountNameCheck(String Name) {
		// i only put a return so it would stop screaming error
		return true;
	}

	public static void writeTransactionsToSummaryFile(String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		while(!tsfQueue.isEmpty()) {
			writer.write(tsfQueue.poll());
			writer.newLine();
		}
		writer.close();
	}

}
