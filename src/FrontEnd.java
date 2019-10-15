import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class FrontEnd {

	//The static Queue name tsf (transaction summary file) queue
	static Queue<String> tsfQueue = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi");

	}

	public void login() {

	}

	public void logout() {
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

	}

	public static void deposit() {

	}

	public static void withdraw() {

	}

	public static void transfer() {

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
