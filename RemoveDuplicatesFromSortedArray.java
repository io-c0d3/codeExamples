/**
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each 
unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result 
be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, 
then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
*/



// WOOOOOOOOOOOOOOOO got a "beats 100%" on the first try. It ran that fast consistently over a few checks. Edit: Occasionally 
// shot up to 124ms but I dont think it was right? Idk scared me a bit, I might be wrong :/

class Solution {
    public int removeDuplicates(int[] nums) {
        // If the array is one or zero indexes long, return the array as it is.
        if (nums.length <= 1) return nums.length;
        // Create a variable to hold the count of how many times you have moved an integer in the array.
        int count = 1;
        // Create a variable to hold the current unique integer that is being worked with.
        int currentNumber = 0;
        // For the length of the array.
        for (int i = 0; i < nums.length; i++) {
            // Set the currentNumber variable to the last realised unique integer.
            currentNumber = nums[i];
            // For every unknown integer in the array:
            for (int n = i + 1; n < nums.length; n++) {
                // If the integer at n is greater than the last realised unique integer:
                if (nums[n] > currentNumber) {
                    // The integer replaces the integer at the position described by the count variable, which
                    // is the number of times an integer has been moved to the correct position.
                    nums[count] = nums[n];
                    // The currentNumber variable is replaced with the new last realised unique integer.
                    currentNumber = nums[n];
                    // Add to count, and break the loop.
                    count++;
                    break;
                } else {
                    // Add to i to skip the duplicates without adding to the count total.
                    i++;
                }
            }
        }

        return count;
    }
}
