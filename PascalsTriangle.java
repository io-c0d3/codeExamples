// Given an integer numRows, return the first numRows of Pascal's triangle.
// Pretty straightforward, got a quick algorithm right off the bat. 
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        // The master list which we will return.
        List<List<Integer>> masterList = new ArrayList<List<Integer>>();
        // If the input is 0, return the empty list.
        if (numRows == 0) return masterList;
        // Add a list containing a single 1 to the master list.
        List firstList = new ArrayList();
        firstList.add(1);
        masterList.add(firstList);
        // For each row (number of which is determined by the input value).
        for (int i = 1; i < numRows; i++) {
            // Create a new list to add to the master list.
            List loopList = new ArrayList();
            // First value in row is always 1.
            loopList.add(1);
            // Get the previous rows list.
            List lastList = masterList.get(i - 1);
            // For each position in the new row, except for the first and last positions.
            for (int n = 1; n < i; n++) {
                // Get the previous rows position above and to the left.
                int first = (int)lastList.get(n - 1);
                // Get the previous rows position above and to the right.
                int next = (int)lastList.get(n);
                // Add the two together and add it to the new row.
                loopList.add(first + next);
            }
            // Last value in row is always 1.
            loopList.add(1);
            // Add the finished loop list to the master list.
            masterList.add(loopList);
        }
        // Return the finished list.
        return masterList;
    }
}
