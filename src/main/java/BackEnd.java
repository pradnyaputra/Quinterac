/**
 * Created by Tyler D.S. Elliott on 06-Nov-19.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap; // import the HashMap class
import java.util.Scanner;

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
		
		for (Integer i : accounts.keySet()) {
			  System.out.println("key: " + i + " value: " + accounts.get(i).getBalance() + " " + accounts.get(i).getAccountName() );
		}
		
	}
	
	public static HashMap<Integer, Account> readOldMasterAccountsFile(String filename) {
		HashMap<Integer, Account> temp = new HashMap<Integer, Account>();
		Scanner file = null;
        //trycatch to open the valid account list file
        try {
            file = new Scanner(new FileInputStream(filename));
            //while loop to ensure all lines are read within the file

            while (file.hasNextLine()) {
                String line = file.nextLine();
                String words[] = line.split(" ");
                //adds every account number from the valid account list file to the hashset
                Account tempAccount = new Account(Integer.parseInt(words[0]), Integer.parseInt(words[1]), words[2]);
                temp.put(Integer.parseInt(words[0]), tempAccount);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return temp;
	}
}
