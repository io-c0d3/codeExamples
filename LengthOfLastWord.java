/**
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
consisting of non-space characters only.
*/


// Kind of fast, could do with some work. Still beats over 50% of other solutions.
class Solution {
    public int lengthOfLastWord(String s) {
        // Work from the end of the array, removing any trailing whitespaces.
        for (int n = s.length() - 1; n > 0; n--) {
            if (s.charAt(n) == ' ') {
                s = s.substring(0, n);
            }
            // Once a non-whitespace character is found, break from the loop.
            else break;
        }
        // If the String doesnt contain any white spaces (except trailing, which are removed with the
        // previous for loop), return the length of the String.
        if (!doesContainSpaces(s)) return s.length();
        // Working backwards, find the first whitespace character, and return the length of the word using
        // the String length minus the index position of the whitespace character.
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') return s.length() - i - 1;
        }
        
        return 0;
    }
    // Returns false if String doesnt contain a space.
    private boolean doesContainSpaces(String s) {
        char[] chars = s.toCharArray();
        boolean flag = false;
        for (char c : chars) {
            if (c == ' ') flag = true;
        }
        return flag;
    }
}
