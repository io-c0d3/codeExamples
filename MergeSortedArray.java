// Nice and quick, this one is consistently scoring at <1ms, or faster than all others.
class Solution {
    // M is to the zeros in nums1, and n is how many zeros and also the length of nums2.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // If there is only 1 index position in each array, and nums1[0] is a 0,
        // copy over the value from nums2[0] and end the method call.
        if (n + m == 1 && nums1[0] == 0) {
            nums1[0] = nums2[0];
            return;
        }
        int mCounter = 0;                   // Keeps track of array index of nums1 values.
        int nCounter = 0;                   // Keeps track of array index of nums2 values.
        int currentIndex = (m + n) - 1;     // Keeps track of array array index of nums1 total positions.
        // While both arrays still have values to rearrange.
        while (m - mCounter > 0 && n - nCounter > 0) {
            // Get the last array index positions for each array.
            int lastNums1 = m - mCounter - 1;
            int lastNums2 = n - nCounter - 1;
            // If nums1[] is larger, put it in the correct position.
            if (nums1[lastNums1] >= nums2[lastNums2]) {
                nums1[currentIndex] = nums1[lastNums1];
                mCounter++;
            }
            // Else if nums2[] is, put it in the correct position.
            else if (nums1[lastNums1] < nums2[lastNums2]) {
                nums1[currentIndex] = nums2[lastNums2];
                nCounter++;
            }
            // Reduce the current index of the overall list (where we are putting the larger values).
            currentIndex--;
        }
        // If nums2 still contains values, add them to the list. Nums1 wont have any values needing moved
        // left because either nums2 is empty and the values are in the right place already, or nums2 has
        // values left which will take the place of values in the nums1 array.
        while (n - nCounter > 0) {
            int lastNums1 = m - mCounter - 1;
            int lastNums2 = n - nCounter - 1;
            nums1[currentIndex] = nums2[lastNums2];
            nCounter++;
            currentIndex--;
        }

    }
}
