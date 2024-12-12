/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;

        if (num.matches("\\d+")) { //if num contain jast numbers
            return Integer.parseInt(num); //return the number
        }

        if (!isNumber(num)) { //if num is elegal
            return ans;
        }

        int Indexb = num.lastIndexOf('b'); //found the index of b

        //dividing to part of number and pert of base:
        String numberPart = num.substring(0, Indexb);
        String basePart = num.substring(Indexb + 1, num.length());

        //convert base from string to int:
        int base = 0;
        if (basePart.matches("\\d+")) {
            base = Integer.parseInt(basePart);
        } else if (Character.isUpperCase(basePart.charAt(0))) {
            base = basePart.charAt(0) - 'A' + 10;
        }


        ans = Integer.parseInt(numberPart, base); //Use in function that accepts number and base and converts them to decimal base

        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param num a String representing a number
     * @return true iff the given String is in a number format
     */
    //check if num is in legal format:
    public static boolean isNumber(String num) {

        if (num == null || num.isEmpty()) { //for null or empty string return false
            return false;
        }

        if (num.matches("\\d+")) { //if num contain jast numbers return true
            return true;
        }

        if (!num.matches("[A-G0-9b]+")) { //For invalid characters return false
            return false;
        }

        int Indexb = num.lastIndexOf('b'); //found the index of b
        if (Indexb == -1 || Indexb == 0 || Indexb == num.length() - 1) { //if b in the firs' last or ther not b, return false
            return false;
        }

        //dividing to part of number and pert of base:
        String numberPart = num.substring(0, Indexb);
        String basePart = num.substring(Indexb + 1, num.length());

        if (basePart.length() != 1) { //if the length of base > 2 return false
            return false;
        }

        if (!basePart.matches("[A-G0-9]+")) { //For invalid characters in basepart return false
            return false;
        }

        if (!numberPart.matches("[A-G0-9]+")) { //For invalid characters in numberpart return false
            return false;
        }

        //convert base from string to int:
        int base;
        if (basePart.matches("\\d+")) {
            base = Integer.parseInt(basePart);
        } else if (Character.isUpperCase(basePart.charAt(0))) {
            base = basePart.charAt(0) - 'A' + 10;
        } else {
            return false;
        }

        if (base < 2 || base > 16) { //if the base is not in range return false
            return false;
        }

        //if the number does not belong to the base return false:
        for (int i = 0; i < numberPart.length(); i++) {
            char charValue = numberPart.charAt(i);
            int numericValue = Character.getNumericValue(charValue);
            int tempNumber = numericValue != -1 ? numericValue : charValue - 'A' + 10;

            if (tempNumber >= base) {
                return false;
            }
        }

        return true;
    }


    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";

        if (num < 0 || base < 2 || base > 16) { //if the base is not in range return false
            return ans;
        }

        if (num < 0) { //if num < 0 return false
            return ans;
        }

        if (base < 2 || base > 16) { //if the base is not in range return false
            return ans;
        }

        ans = Integer.toString(num, base).toUpperCase(); //Use in function that accepts num and base and converts them to string

        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param num1 first number
     * @param num2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String num1, String num2) {
        boolean ans = true;

        if (!isNumber(num1) || !isNumber(num2)) { //if the numbers elegal return false
            return false;
        }

        //comparison between numbers:
        if (number2Int(num1) != number2Int(num2)) {
            return false;
        }
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int decimalValue = number2Int(arr[i]);

            if (decimalValue > ans) { //checking which number is bigger
                ans = decimalValue;
            }

        }
        return ans;
    }
}


