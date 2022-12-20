/**
You are given a large integer represented as an integer array digits, where each digits[i] is 
the ith digit of the integer. The digits are ordered from most significant to least significant in 
left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
*/



// Pretty fast off the bat! 
class Solution {
    public int[] plusOne(int[] digits) {
        // For all of the integers in the array, working backwards.
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the digit is any from 0 - 8, add a 1 and end the loop.
            if(digits[i] != 9) {
                digits[i] += 1;
                break;
            } 
            // If the digit is a 9, make it zero and add carry.
            else {
                digits[i] = 0;
                // If the position being modified is the first index in the array [0], create a new array,
                // set [0] as a 1, and then copy the integers from the digits array to fill the rest of the array.
                if(i == 0) {
                    int[] temp = new int[digits.length + 1];
                    temp[0] = 1;
                    for (int n = 1; n < temp.length; n++) {
                        temp[n] = digits[n - 1];
                    }
                    // Set the extended array as digits.
                    digits = temp;
                }
            }
        }
        // Return the ammended array.
        return digits;
    }
}
