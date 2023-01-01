// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

// Less verbose, only using two ArrayLists. It doesnt run any faster though.
class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Create the masterlist and the first row in the triangle.
        List firstList = new ArrayList();
        firstList.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List loopList = new ArrayList();
            // Start of row is always a 1.
            loopList.add(1);            
            for (int n = 1; n < i; n++) {
                int first = (int)firstList.get(n - 1);
                int next = (int)firstList.get(n);
                loopList.add(first + next);
            }
            // End of row is always a 1.
            loopList.add(1);
            // Set the List we are working from to the newly created List.
            firstList = loopList;
        }

        return firstList;
    }
}


// // My solution is OK, but a bit verbose - I could try a version where I dont store the master list and just go with 2 Lists.
// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         // Create the masterlist and the first row in the triangle.
//         List<List<Integer>> masterList = new ArrayList<List<Integer>>();
//         List firstList = new ArrayList();
//         firstList.add(1);
//         masterList.add(firstList);

//         for (int i = 1; i <= rowIndex; i++) {
//             List loopList = new ArrayList();
//             // Start of row is always a 1.
//             loopList.add(1);
//             List lastList = masterList.get(i - 1);
            
//             for (int n = 1; n < i; n++) {
//                 int first = (int)lastList.get(n - 1);
//                 int next = (int)lastList.get(n);
//                 loopList.add(first + next);
//             }

//             // End of row is always a 1.
//             loopList.add(1);
//             masterList.add(loopList);
//         }

//         return masterList.get(rowIndex);
//     }
// }
