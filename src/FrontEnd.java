import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FrontEnd {

	public static Queue transactionQueue = new LinkedList();

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

	public static void createacct() {
		System.out.println("createacct");
		defaultScreen();
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

	}


}
