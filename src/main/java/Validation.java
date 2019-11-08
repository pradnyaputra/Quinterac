import java.util.HashSet;

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

        return number.charAt(0) != '0';
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
        return (name.matches("[a-zA-Z0-9]+"))
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
}

