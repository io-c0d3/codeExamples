/**
Given two binary strings a and b, return their sum as a binary string.
  */



import java.lang.Math;

class Solution {
    public String addBinary(String a, String b) {
        // Set variables to hold the integer values of each input String.
        // int firstNumber = getIntegerFromBinary(a);
        // int secondNumber = getIntegerFromBinary(b);
        // if (firstNumber + secondNumber == 0) return "0";
        if (a.charAt(0) == '0' && b.charAt(0) == '0') return "0";
        String result = addWithCarry(a, b);
        return result;
    }
    
    // Boring way with carry boolean. Adds each array position as you go.
    private String addWithCarry(String a, String b) {
        // Variables to store the final String, and the length of the two input Strings.
        String result = "";
        int aLength = a.length();
        int bLength = b.length();
        // Variable for the for loop to use as a carry.
        boolean carry = false;
        // Get the length of the longer of the two input Strings.
        int longerString = a.length();
        if (b.length() > a.length()) longerString = b.length();
        // For the length of the longer of the two input Strings.
        for (int i = longerString; i > 0; i--) {
            // Set a counter variable.
            int total = 0;
            // If a[i] exists, if its a 1, add 1 to total and decrease aLength, else just decrease aLength.
            if (aLength > 0) {
                if (a.charAt(aLength - 1) == '1') {
                    total++;
                    aLength--;
                }
                else {
                    aLength--;
                }
            }
            // If b[i] exists, if its a 1, add 1 to total and decrease bLength, else just decrease bLength.
            if (bLength > 0) {
                if (b.charAt(bLength - 1) == '1') {
                    total++;
                    bLength--;
                }
                else {
                    bLength--;
                }
            }
            // If the carry is true, add 1 to total.
            if (carry) total++;
            // If statements for modifying the String depending on the total count, and setting the carry boolean.
            if (total == 0) {
                result = '0' + result;
                carry = false;
            }
            else if (total == 1) {
                result = '1' + result;
                carry = false;
            }
            else if (total == 2) {
                result = '0' + result;
                carry = true;
            }
            else if (total == 3) {
                result = '1' + result;
                carry = true;
            }
        }
        // If the carry boolean is still set after the String indexes have all been worked on, add a 1 to the front of the array.
        if (carry) {
            result = "1" + result;
        }
        // Return the result String.
        return result;
    }

     // Helper method to get the integer value of an input String. Doesnt work on large integers.
    private int getIntegerFromBinary(String input) {
        int total = 0;
        int powerOf = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == '1') {
                total += Math.pow(2, powerOf);
            }
            powerOf++;
        }
        return total;
    }

    // Helper method to get a binary value as a String from an integer. Doesnt work on large integers.
    private String getBinaryStringFromInteger(int input) {
        
        // Get the highest power that is smaller than input.
        int powers = 0;
        for (int i = 0; ; i++) {
            if (!(Math.pow(2, powers) > input)) {
                powers++;
            }
            else break;
        }

        String result = "";
        int holdInput = input;

        // While powers is greater than 0, if input is larger than the current 2^powers, add a 1 to the result String
        // and remove 2^powers from input. Else add a 0 to the result String.
        while (powers > 0) {
            if (holdInput >= Math.pow(2, powers - 1)) {
                holdInput = holdInput - (int) Math.pow(2, powers - 1);
                result = result + "1";
                powers--;
            } else {
                result = result + "0";
                powers--;
            }
        }
        return result;
    }
}
