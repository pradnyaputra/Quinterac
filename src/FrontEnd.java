
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class FrontEnd {

	//The static Queue name tsf (transaction summary file) queue
	static Queue<String> tsfQueue = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login();
		System.out.println("hi");

	}

	public static void login() {
		defaultScreen();
	}

	public static void logout() {
		System.out.println("logout");
		defaultScreen();
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

			if (accountNumberCheck(accNum) && !accountNumberExists(accNum)) {
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
		defaultScreen();
	}

	public static void deposit() {
		System.out.println("deposit");
		defaultScreen();
	}

	public static void withdraw() {
		System.out.println("withdraw");
		defaultScreen();
	}


	public static void transfer() {
		System.out.println("transfer");
		defaultScreen();
	}

	/*
	* Common helper functions
	* */
	public static void defaultScreen() {
		Scanner input = new Scanner(System.in);
		switch(input.nextLine()) {
			case "logout":
				logout();
				break;
			case "createacct":
				createacct();
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
				defaultScreen();
		}


	public static boolean accountNumberCheck(String Num) {
		// i only put a return so it would stop screaming error
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

}
