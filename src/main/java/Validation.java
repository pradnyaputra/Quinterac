/**
 * This class is dedicated to hosting all validation methods. All methods in this class are public, and can
 * therefore be called by both frontend and backend in order to validate incoming/outgoing data
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Validation {

    /**
     * This method will check and return true if the account number in the parameter is valid. Else, it will return false
     * @param number the value to check
     */
    public static boolean accountNumberValid(String number) {
        // trims leading and trailing spaces of the string
        number = number.trim();
        if (!isAllDigits(number)) {
            return false;
        }

        if (number.length() != 7) {
            return false;
        }

        if (number.charAt(0) == '0' && !number.equals("0000000")) {
            return false;
        }
        return true;
    }

    /**
     * This method will check and return true if the parameter is a number. Else, it will return false
     * @param number the value to check
     */
    public static boolean isAllDigits(String number) {
        //loops through all characters of the string and checks if it is a digit
        for (Character x : number.toCharArray()) {
            if (!Character.isDigit(x)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method will check and return true if the account name in the parameter is valid. Else, it will return false
     * @param name the value to check for validity
     */
    public static boolean accountNameValid(String name) {
        //returns a boolean variable if the following conditions are true
        return (name.matches("[a-zA-Z0-9 ]+"))
                && (name.length() <= 30)
                && (name.length() >= 3)
                && !((name.charAt(0) == ' ')
                && name.charAt(name.length() - 1) == ' ');
    }

    /**
     * This method will check and return true if the account number in the parameter exists in the hash set. Else, it will return false
     */
    public static boolean accountNumberExists(HashSet <String> accountList, String number) {
        return accountList.contains(number);
    }

    /**
     * This method will check and return true if the value in the parameter is a valid monetary value (according to requirements). Else, it will return false
     * @param number the value to validate
     */
    public static boolean validMonetaryAmount(String number) {
        int value = Integer.parseInt(number);
        if (number.length() >= 3 && number.length() <= 8) {
            if (value >= 0 && value <= 99999999) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method will check and return true if all files entered into the backend are valid. Else, it will return false
     * @param tsf the location of the Merged Transaction Summary file
     * @param maf the location of the old Master Accounts File
     */
    public static void BackendFileValidity(String tsf, String maf) {
        //Calls individual methods that check the specific files for validity
        if (isMafValid(maf)) {
            if (isTsfValid(tsf))
                return;
        }
        //if any of the conditions return false, then the system will display an error and exit with status 1 (error).
        System.out.println("FATAL ERROR: Input file validity check failed.");
        System.exit(1);
    }

    /**
     * This method will check and return true if the old master accounts file is valid. Else, it will return false
     * @param filename the location of the old Master Accounts file
     */
    public static boolean isMafValid(String filename) {
        Scanner file = null;
        try {
            file = new Scanner(new FileInputStream(filename));

            String prevAccNumber="99999999";
            //while loop to ensure all lines are read within the file
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] words = line.split(" ");

                //checks to ensure that the next account number is less than the previous one (descending order)
                if(Integer.parseInt(words[0]) >= Integer.parseInt(prevAccNumber)){
                    System.out.println("1");
                    return false;
                }

                //Checks to ensure the line is not longer than 47 characters
                if (line.length()>47){
                    System.out.println("2");
                    file.close();
                    return false;
                }

                //Checks to ensure that the account number is valid (Exists etc)
                if(!accountNumberValid(words[0])){
                    System.out.println("3");
                    file.close();
                    return false;
                }

                //Checks to ensure that the account name is valid
                if(!accountNameValid(String.join(" ", Arrays.copyOfRange(words, 2, words.length)))){
                    System.out.println("4");
                    file.close();
                    return false;
                }

                //Checks to ensure the first character of the account number is not a 0
                if (line.substring(0, 1).equals("0")) {
                    System.out.println("5");
                    file.close();
                    return false;
                }

                //sets prevAccNumber to the current acc number, to be used in the next cycle for descending order
                prevAccNumber = words[0];
            }
            file.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return false;
    }

    /**
     * This method will check and return true if the merged transaction summary file is valid. Else, it will return false
     */
    public static boolean isTsfValid(String filename) {
        Scanner file = null;
        try {
            file = new Scanner(new FileInputStream(filename));

            //while loop to ensure all lines are read within the file
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] words = line.split(" ");

                if (line.equals("EOS")) {
                    continue;
                }

                //Checks to ensure the line is not longer than 61 characters
                if (line.length() > 61) {
                    file.close();
                    return false;
                }

                //Checks to ensure the command is one of the following valid commands
                if (!words[0].equals("DEP") && !words[0].equals("WDR") && !words[0].equals("XFR") &&
                        !words[0].equals("NEW") && !words[0].equals("DEL") && !words[0].equals("EOS")) {
                    file.close();
                    return false;
                }

                //Checks to ensure that the account number is valid
                if (!Validation.accountNumberValid(words[1]) || !Validation
                        .accountNumberValid(words[3])) {
                    file.close();
                    return false;
                }

                //Checks to ensure that the monetary value is valid
                if (!Validation.validMonetaryAmount(words[2])) {
                    file.close();
                    return false;
                }

                //checks to ensure that the account name is valid
                if (!Validation.accountNameValid(String.join(" ",
                        Arrays.copyOfRange(words, 2, words.length))) && !words[4].equals("***")) {
                    file.close();
                    return false;
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return true;
    }
}

