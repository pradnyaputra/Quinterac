/*
 * Developed by YES-MEN team
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FrontEnd {

	//declaring global values that will be used through direct reference throughout the program
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

	//startUp method introduces the program and requests for initial user commands
	private static void startUp() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Quinterac, developed by YES-MEN");
		System.out.println("Please enter 'login' to begin using the service");
		while (!input.nextLine().equals("login")) {
			System.out.println("The only valid command is login");
		}
		
		//agent boolean value to determine the mode (agent or !agent (aka machine))
		boolean agent = login();
		
		//While loop will loop continuously (until logout is called), enabling the execution of several methods within a single session.
		while (!loggedOut) {
			
			//switch case to check user input and execute the corresponding method
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

	//login method called by startUp method, asking for user mode
	private static boolean login() {
		System.out.println("Do you want a machine or agent session?");
		Scanner input = new Scanner(System.in);
		boolean agent;
		String sessionType = input.nextLine();
		
		//While loop to ensure either machine or agent is entered (all other options invalid)
		while (!sessionType.equals("machine") && !sessionType.equals("agent")) {
			System.out.println("The only valid options are 'machine' or 'agent'");
			sessionType = input.nextLine();
		}
		//determines whether agent boolean is true or false based on input
		agent = sessionType.equals("agent");
		
		//Sets the variable loggedOut to false, ensuring that multiple methods can be executed in a single session
		loggedOut = false;
		System.out.println("Logged in");
		return agent;
	}

	//logout method notifies user of end of session, adds EOS to tsfQueuem, and writes to transaction summary file
	private static void logout() {
		System.out.println("The session has been closed for the day");
		String endOfSession = "EOS";
		tsfQueue.add(endOfSession);
		
		//trycatch to write data from tsfQueue into transaction summary file
		try {
			writeTransactionsToSummaryFile("transactionSummaryFile.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//sets the logout variable to true, preventing the main menu from looping
		loggedOut = true;
		startUp();
	}

	//createAcct creates a new account using user input and adds transaction code to tsfQueue
	private static void createAcct(boolean agent) {
		Scanner input = new Scanner(System.in);

		String accName;
		String accNum;
		String tsfData;
		
		//checking whether in agent or machine mode
		if (!agent) {
			System.out.println("Please use agent mode to access this command.");
			return;
		} else {// machine mode
			System.out.println("Please enter the new account number: ");
			accNum = input.nextLine();

			//proceeds with account creation after account number has been validated, and there is no current account with that account number
			if (accountNumberValid(accNum) && !accountNumberExists(accNum)) {
				System.out.println("Please enter an account name: ");
				accName = input.nextLine();

				//verifies the validity of the account name, and then adds the corresponding transaction code tsfQueue
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

	//deleteAcct deletes an existing account and adds transaction code to tsfQueue
	private static void deleteacct(boolean agent) {
		Scanner input = new Scanner(System.in);
		String accName;
		String accNum;
		String tsfData;

		//checking whether in agent or machine mode
		if (!agent) {
			System.out.println("Please use agent mode to access this command.");
			return;
		} else {
			System.out.println("Please enter the your account number: ");
			accNum = input.nextLine();

			//proceeds with account deletion after account number has been validated, and there is currently an account with that account number
			if (accountNumberValid(accNum) && accountNumberExists(accNum)) {
				System.out.println("Please enter your account name: ");
				accName = input.nextLine();
				
				//verifies the validity of the account name, and then adds the corresponding transaction code tsfQueue
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

	//deposits money into an account and adds transaction code to tsfQueue
	private static void deposit(boolean agent) {
		Scanner input = new Scanner(System.in);
		String amount;
		String accNum;
		String tsfData;

		System.out.println("Please enter the your account number: ");
		accNum = input.nextLine();

		//proceeds with deposit after account number has been validated, and there is currently an account with that account number
		if (accountNumberValid(accNum) && accountNumberExists(accNum)) {
			System.out.println("Please enter the amount you wish to deposit: ");
			amount = input.nextLine();

			if (isAllDigits(amount)) {
				
				//checking whether in agent or machine mode
				if (agent) {
					
					//verifies the validity of the amount to deposit, and then adds the corresponding transaction code tsfQueue
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
					
					//verifies the validity of the amount to deposit, and then adds the corresponding transaction code tsfQueue
					if (Integer.parseInt(amount) >= 0 && Integer.parseInt(amount) <= 200000) {
						int dailyTotal = 0;
						
						//loops through tsfQueue to sum the amount of cash deposited into that account so far in the day
						for (int i = 0; i < tsfQueue.size(); i++) {
							String queueVal = tsfQueue.poll();
							String[] queueValArr = queueVal.split(" ");
							if (queueValArr[0].equals("WDR") && queueValArr[1].equals(accNum)) {
								dailyTotal += Integer.parseInt(queueValArr[2]);
							}
							tsfQueue.add(queueVal);
						}
						
						//checks whether the account has exceeded this specific daily transaction limit
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

	//withdraws from an account and adds transaction code to tsfQueue
	private static void withdraw(boolean agent) {
		Scanner input = new Scanner(System.in);
		String amount;
		String accNum;
		String tsfData;

		System.out.println("Please enter the your account number: ");
		accNum = input.nextLine();

		//proceeds with withdrawal after account number has been validated, and there is currently an account with that account number
		if (accountNumberValid(accNum) && accountNumberExists(accNum)) {
			System.out.println("Please enter the amount you wish to withdraw in cents: ");
			amount = input.nextLine();

			if (isAllDigits(amount)) {
				
				//checking whether in agent or machine mode
				if (agent) {
					
					//verifies the validity of the amount to withdraw, and then adds the corresponding transaction code tsfQueue
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
					
					//verifies the validity of the amount to withdraw, and then adds the corresponding transaction code tsfQueue
					if (Integer.parseInt(amount) >= 0 && Integer.parseInt(amount) <= 100000) {
						int dailyTotal = 0;
						
						//loops through tsfQueue to sum the amount of cash withdrawn into that account so far in the day
						for (int i = 0; i < tsfQueue.size(); i++) {
							String queueVal = tsfQueue.poll();
							String[] queueValArr = queueVal.split(" ");
							if (queueValArr[0].equals("WDR") && queueValArr[3].equals(accNum)) {
								dailyTotal += Integer.parseInt(queueValArr[2]);
							}
							tsfQueue.add(queueVal);
						}
						
						//checks whether the account has exceeded this specific daily transaction limit
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

		//proceeds with transfer after account numbers have been validated, and there are currently accounts with those account numbers
		if (accountNumberValid(accNumTo) && accountNumberExists(accNumTo) && accountNumberValid(accNumFrom) && accountNumberExists(accNumFrom)) {
			System.out.println("Please enter the amount you wish to transfer in cents: ");
			amount = input.nextLine();

			if (isAllDigits(amount)) {
				
				//checking whether in agent or machine mode
				if (agent) {
					
					//verifies the validity of the amount to transferred, and then adds the corresponding transaction code tsfQueue
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
					
					//verifies the validity of the amount to transfer, and then adds the corresponding transaction code tsfQueue
					if (Integer.parseInt(amount) >= 0 && Integer.parseInt(amount) <= 1000000) {
						int dailyTotal = 0;
						
						//loops through tsfQueue to sum the amount of cash transferred from that account so far in the day
						for (int i = 0; i < tsfQueue.size(); i++) {
							String queueVal = tsfQueue.poll();
							String[] queueValArr = queueVal.split(" ");
							if (queueValArr[0].equals("WDR") && queueValArr[1].equals(accNumFrom)) {
								dailyTotal += Integer.parseInt(queueValArr[2]);
							}
							tsfQueue.add(queueVal);
						}
						
						//checks whether the account has exceeded this specific daily transaction limit
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

	//checks whether the string entered consists only of integers or not
	private static boolean isAllDigits(String number) {
		
		//loops through all characters of the string and checks if it is a digit
		for (Character x : number.toCharArray()) {
			if (!Character.isDigit(x)) {
				return false;
			}
		}
		return true;
	}

	//checks whether the account number is valid by following the constraints
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

	//checks whether an account number exists in the valid account list file
	private static boolean accountNumberExists(String number) {
		Scanner file = null;
		//trycatch to open the valid account list file
		try {
			file = new Scanner(new FileInputStream("validAccountList.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		//while loop to ensure all lines are read within the file
		while (file.hasNextLine()) {
			String line = file.nextLine();
			//will return true if the account number is found
			if (line.equals(number)) {
				return true;
			}
		}
		file.close();
		//will return false if the while loop exits without finding the account number
		return false;

	}

	//Checks whether an account name is valid by following constraints
	private static boolean accountNameValid(String name) {

		//returns a boolean variable if the following conditions are true
		return (name.matches("[a-zA-Z0-9]+"))
				&& (name.length() <= 30)
				&& (name.length() >= 3)
				&& !((name.charAt(0) == ' ')
				&& name.charAt(name.length() - 1) == ' ');

	}

	//Accepts filename and then empties the tsfQueue while writing tsfQueue's data into the transaction summary file
	private static void writeTransactionsToSummaryFile(String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		
		//while loop to ensure the queue is processed until it is fully emptied
		while (!tsfQueue.isEmpty()) {
			writer.write(tsfQueue.poll());
			writer.newLine();
		}
		writer.close();
	}
}
