import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Validation {

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

    public static boolean isAllDigits(String number) {
        //loops through all characters of the string and checks if it is a digit
        for (Character x : number.toCharArray()) {
            if (!Character.isDigit(x)) {
                return false;
            }
        }
        return true;
    }

    public static boolean accountNameValid(String name) {
        //returns a boolean variable if the following conditions are true
        return (name.matches("[a-zA-Z0-9 ]+"))
                && (name.length() <= 30)
                && (name.length() >= 3)
                && !((name.charAt(0) == ' ')
                && name.charAt(name.length() - 1) == ' ');
    }

    //checks whether an account number exists in the valid account list file
    public static boolean accountNumberExists(HashSet <String> accountList, String number) {
        return accountList.contains(number);
    }

    public static boolean validMonetaryAmount(String number) {
        int value = Integer.parseInt(number);
        if (number.length() >= 3 && number.length() <= 8) {
            if (value >= 0 && value <= 99999999) {
                return true;
            }
        }
        return false;
    }

    public static void BackendFileValidity(String tsf, String maf) {
        if (isMafValid(maf)) {
            if (isTsfValid(tsf))
                return;
        }
        System.out.println("FATAL ERROR: Input file validity check failed.");
        System.exit(1);
    }


    //Checks the Valid Account List file to see if it is valid or not
    public static boolean isMafValid(String filename) {
        Scanner file = null;
        try {
            file = new Scanner(new FileInputStream(filename));

            String prevAccNumber="9999999";
            //while loop to ensure all lines are read within the file
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] words = line.split(" ");

                if(Integer.parseInt(words[0]) >= Integer.parseInt(prevAccNumber)){
                    return false;
                }

                if (line.length()>47){
                    file.close();
                    return false;
                }

                if(!accountNumberValid(words[0])){
                    file.close();
                    return false;
                }

                if(!accountNameValid(String.join(" ", Arrays.copyOfRange(words, 2, words.length)))){
                    file.close();
                    return false;
                }

                if (line.substring(0, 1).equals("0")) {
                    file.close();
                    return false;
                }

                prevAccNumber = words[0];
            }
            file.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return false;
    }

    //Checks the Transaction Summary File to see if it is valid or not
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

                if (line.length() > 61) {
                    file.close();
                    return false;
                }
                if (!words[0].equals("DEP") && !words[0].equals("WDR") && !words[0].equals("XFR") &&
                        !words[0].equals("NEW") && !words[0].equals("DEL") && !words[0].equals("EOS")) {
                    file.close();
                    return false;
                }
                if (!Validation.accountNumberValid(words[1]) || !Validation
                        .accountNumberValid(words[3])) {
                    file.close();
                    return false;
                }
                if (!Validation.validMonetaryAmount(words[2])) {
                    file.close();
                    return false;
                }
                if (!Validation.accountNameValid(words[4]) && !words[4].equals("***")) {
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

