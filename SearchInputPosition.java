/**
Given a sorted array of distinct integers and a target value, return the index if the target is 
found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
*/



// Fast af, got this one on my first try :) Used a recursive divide and conquer to find the appropriate
// index of the target integer, whether it exists or not.
class Solution {
    public int searchInsert(int[] nums, int target) {
        // This is divide and conquer. Find the upper and lower bounds of the array.
        int lowerBound = 0;
        int upperBound = nums.length;
        // If the target value is lesser than the first item in the array, it belongs at the start.
        if (nums[lowerBound] > target) return 0;
        // If the target value is greater than the last item in the array, it belongs at the end.
        if (nums[upperBound - 1] < target) return upperBound;
        // Call the recursive method, initially using the upper and lower bounds.
        return getIndex(nums, upperBound, lowerBound, target);
    }

    // Recursive method to find the either real or expected location of an integer in the array.
    private int getIndex(int[] nums, int upperBound, int lowerBound, int target) {
        // Get the middle index position.
        int centerIndex = (lowerBound + upperBound) / 2;
        // Create a variable to hold the return value of the recursion.
        int returnIndex = 0;
        // If the target value equals the array value at center index, return the value.
        if (nums[centerIndex] == target) return centerIndex; 
        // If the target value doesnt exist in the array.
        else if (nums[centerIndex - 1] < target && nums[centerIndex] > target) {
            return centerIndex;
        }
        else if (nums[centerIndex] < target && nums[centerIndex] + 1 > target) {
            return centerIndex;
        }
        // If the target value is larger than the number at array position center.
        else if (nums[centerIndex] > target) {
            returnIndex = getIndex(nums, centerIndex, lowerBound, target);
        }
        // If the target value is smaller than the number at array position center.
        else if (nums[centerIndex] < target) {
            returnIndex = getIndex(nums, upperBound, centerIndex, target);
        }
        // Return the appropriate index value.
        return returnIndex;
    }
}
