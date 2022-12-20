/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/


// Took a look at the lead solution. This one uses more memory than my own
// brute force approach, but it is waaaaay faster.
// I believe that removing the check for the array positions being the same took
// the code from O(N^2 * 2) to (I was told, I dont understand how this works
// for triangle numbers) O(sqrtN)

class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 1; i < nums.length; i++) {
            for (int k = i; k < nums.length; k++) {
            // I removed a check for the i and k being the same from here, which
            // ran every iteration of the loop. This was done by using the code below
            // to start k as 1, and then check k - i for the result. 
            // eg, 
            // With the array [1, 2, 3, 4] and the target as 7, the checks would be
            // 2 + 1, 3 + 2, 4 + 3, 3 + 1, 4 + 3.
            // This algorithm checks for the smallest difference possible first, and then larger
            // differences. 
            if (nums[k] + nums[k-i] == target) {
                return new int[]{k-i,k};
            }
            }
        }

        return null;
    }
}

// With the array [1, 2, 3, 4] the checks would be
// 2 + 1, 3 + 2, 4 + 3, 3 + 1, 4 + 2, 4 + 1. (6 total)

// With the array [4, 2, 5, 4, 7] the checks would be
// 2 + 4, 5 + 2, 4 + 5, 7 + 4, 5 + 4, 4 + 2, 7 + 5, 4 + 4, 7 + 2, 7 + 4. (10 total)

// The pattern indicates 0, 1, 2, 3, 4 etc for each position in the array. So with array size = n,
// the answer is a triangular number, which can be found with the equation (n * (n+1) / 2). Triangular numbers
// apparently have a big O complexity of O(sqrtN).
