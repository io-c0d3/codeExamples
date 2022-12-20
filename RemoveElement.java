/**
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The 
relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages, you must instead have the 
result be placed in the first part of the array nums. More formally, if there are k elements after 
removing the duplicates, then the first k elements of nums should hold the final result. It does not matter 
what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place 
with O(1) extra memory.
*/



// Fast as a mf. Yeet.

class Solution {
    public int removeElement(int[] nums, int val) {
        if (doesArrayOnlyContainVal(nums, val)) return 0;
        if (!doesArrayContainVal(nums, val)) return nums.length;
        // For each integer in the array, check if it is equal to val, and if it is, swap it with the last element in the array 
        // that isnt equal to val.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int lastIndex = getLastGoodArrayIndex(nums, val);
                if (lastIndex <= i) break;
                int temp = nums[i];
                nums[i] = nums[lastIndex];
                nums[lastIndex] = temp;
            }
        }
        return getLastGoodArrayIndex(nums, val) + 1;
    }
    // Returns true if the array only contains val.
    private boolean doesArrayOnlyContainVal(int[] nums, int val) {
        boolean flag = true;
        for (int i : nums) {
            if (i != val) flag = false;
        }
        return flag;
    }
    // Returns true if the array contains at least one instance of val.
    private boolean doesArrayContainVal(int[] nums, int val) {
        boolean flag = false;
        for (int i : nums) {
            if (i == val) flag = true;
        }
        return flag;
    }
    // Returns the array index closest to the end that doesnt match val.
    private int getLastGoodArrayIndex(int[] nums, int val) {
        
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != val) return i;
        }
        // Return the index
        return 0;
    }
}
