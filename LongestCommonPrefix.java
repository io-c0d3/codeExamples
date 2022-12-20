/**
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
/*


/**
    This was quite a round about way of going about things, when considering how condensed the top result is. But all
    things considered, the algorithm runs reasonably quickly.
 */
class Solution {
    /**
        Returns the most common prefix that every String in the passed in array contains.
     */
    public String longestCommonPrefix(String[] strs) {
        // Get the length of the array, and return an empty String if the array is empty.
        int firstIndex = 0;
        int lastIndex = strs.length - 1;
        if (lastIndex == -1) {
            return "";
        }
        // Sort the array into lexicographic order.
        quickSort(strs, firstIndex, lastIndex);
        if (strs[0].isEmpty()) {
            return "";
        }
        String longestPrefix = getLongestPrefix(strs);
        return longestPrefix;
    }

    /**
        Get the longest prefix shared by ALL of the words in the String.
     */
    private String getLongestPrefix(String[] array) {
        int startIndex = 0;
        int lastIndex = array.length - 1;
        int shorterOfTwoWords = array[startIndex].length();
         if (array[lastIndex].length() < shorterOfTwoWords) {
            shorterOfTwoWords = array[lastIndex].length();
        }
        int indexCounter = -1;
        for (int i = 0; i < shorterOfTwoWords; i++) {
            if (array[startIndex].charAt(i) == array[lastIndex].charAt(i)) {
                indexCounter = i;
            }
            else {
                break;
            }
        }
        return array[0].substring(0, indexCounter + 1);
    }

    /**
        Recursively quicksort the array of Strings.
     */
    private void quickSort(String[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);
            quickSort(array, start, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    /**

     */
    private int partition(String[] arr, int begin, int end) {
        // Set the pivot String as the last position of the array.
        String pivot = arr[end];
        // Get the variable i, which we use to keep count. 
        int i = (begin-1);
        // For every index between the start and the end of the input array:
        for (int j = begin; j < end; j++) {
            // If the index position is lexicographically smaller than or equal to the pivot:
            if (arr[j].compareTo(pivot) <= 0) {
                // Increase i by 1.
                i++;
                // Hold the String at the array position of i in a variable.
                String swapTemp = arr[i];
                // Swap the values of the array positions i and j.
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        // Hold the String at the array position of i + 1 in a variable.
        String swapTemp = arr[i+1];
        // Swap the String at array position i + 1 with the pivot String.
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        // Return i.
        return i+1;
    }

}

/**
sort alphabetically 
...so let's write a quicksort!
 */
