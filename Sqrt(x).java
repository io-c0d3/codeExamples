// Find the square root of x, without using exponent functions (pow(x, 0.5) or x ** 0.5).
// This took a bit of time and work, but im very happy with the result, which according to LeetCodes
// (not particularly accurate) system took 1 - 3ms.

class Solution {
    public int mySqrt(int x) {
        // Checks if x is less than 5 (except 4). Using 1 and 2 as bounds gets the algorithm stuck.
        if (x == 1 || x == 2 || x == 3) return 1;
        else if (x == 0) return 0;
        else if (x == 5) return 2;
        // Need to divide and conquer it for large numbers.
        int lastLower = 0;
        int lowerBound = 2;
        int upperBound = x / 2;
        // Loops until the win condition is found.
        while (true) {
            // If the 2 bounds are consecutive, it means lowerBound is the result to return, as there
            // are no numbers left that could be a closer match.
            if (lowerBound == upperBound - 1) return lowerBound;
            int halfway = (lowerBound + upperBound) / 2;
            // If halfway is larger than the largest possible square root of an integer, set the upperBound
            // as the maximum possible square root.
            if (halfway > 46341) {
                upperBound = 46341;
            }
            // If we have found the answer, return it.
            else if (halfway * halfway == x) {
                return halfway;
            }
            // If halfway squared is greater than x, set halfway as the upperBound.
            else if (halfway * halfway > x) {
                upperBound = halfway;
            }
            // If halway squared is lesser than x, set halway as the lowerBound.
            else if (halfway * halfway < x) {
                lowerBound = halfway;
            }
            
        }
    }
}
