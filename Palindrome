/**
Given an integer x, return true if x is a palindrome, and false otherwise.
*/

class Solution {
    public boolean isPalindrome(int x) {

        // By far the fastest solution. I made about half, but I stole bits from the fastest solution.
        // Check if the number is a negative. If it is, it starts with a - symbol and cant be a palindrome.
        // Also, if the number cleanly divides by 10 but isnt 0 it wont be a paladrome, since leading zeros
        // arent used.
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        // Create a variable to hold the number we build.
        int temp = 0;
        // While x is greater than temp, do this loop. I learnt here that you can directly work on the value x
        // passed into the method, as if it is a variable we have created. Java passes by value; with primitive
        // types this is the actual value. With Objects, this is the value of the location in memory, but you
        // cant alter the original Objects values.
        while (x > temp) {
            temp = (temp * 10) + (x % 10);
            x = x / 10;
        }

        if (x == temp || x == (temp / 10)) {
            return true;
        }
        
        return false;
        


        // Ok, much closer, but I should try without the tempX variable.

        // int temp = 0;
        // int tempX = x;

        // do {
        //     temp = (temp * 10) + (tempX % 10);
        //     System.out.println("temp: " + temp + "  tempX: " + tempX);
        //     if (temp == tempX) return true;
        //     tempX = tempX / 10;
        //     if (temp == tempX) return true;

        // } while (tempX > 0);

        // return false;


        
        // Method that I thought was clever but its slow as fuck.

        // if (x < 0 || x > 9 && x % 10 == 0) {
        //     return false;
        // } else if (x == 0) {
        //     return true;
        // }

        // int temp = 0;
        // int tempX = x;
        // int tempZ = 0;

        // while (tempX > 0) {
        //     temp = (temp * 10) + (tempX % 10);
        //     System.out.println("1  temp: " + temp + "  tempX: " + tempX + "  tempZ: " + tempZ);
        //     if (temp == tempX || temp == tempZ) return true;
        //     tempZ = tempX;
        //     tempX = tempX / 10;
        //     System.out.println("2  temp: " + temp + "  tempX: " + tempX + "  tempZ: " + tempZ + "\n");

        // }
        // return false;


        // // Method using ArrayList. Slower again than LinkedList. Its hard to gauge how much memory it uses, since leetcode
        // // gauges it all over the show.
        // int holdX = x;
        // ArrayList<Integer> arrayList = new ArrayList<Integer>();

        // while (holdX > 0) {
        //     arrayList.add(holdX % 10);
        //     holdX = holdX / 10;
        // }

        // int arrayListSize = arrayList.size() / 2;

        // for (int i = arrayListSize; i >= 1; i--) {
        //     System.out.println("arrayListsize/i: " + arrayListSize + " " + i);
        //     System.out.println("first: " + arrayList.get(0) + " second: " + arrayList.get(arrayList.size() - 1));
        //     if (arrayList.get(0) != arrayList.get(arrayList.size() - 1)) {
        //         return false;
        //     }
        //     arrayList.remove(0);
        //     arrayList.remove(arrayList.size() - 1);
        // }
        


        // // Method using LinkedList. Slower than stack by miles. Used a little less memory.
        // int holdX = x;
        // LinkedList linkedList = new LinkedList();
        
        // while (holdX > 0) {
        //     linkedList.add(holdX % 10);
        //     holdX = holdX / 10;
        // }

        // int listSize = linkedList.size() / 2;

        // for (int i = listSize; i >= 1; i--) {
        //     System.out.println("listsize/i: " + listSize + " " + i);
        //     System.out.println("first: " + linkedList.get(0) + " second: " + linkedList.get(linkedList.size() - 1));
        //     if (linkedList.get(0) != linkedList.get(linkedList.size() - 1)) {
        //         return false;
        //     }
        //     linkedList.remove(0);
        //     linkedList.remove(linkedList.size() - 1);
        // }
    


        // // Method using stacks.
        // int holdX = x;
        // Stack firstStack = new Stack();
        // Stack secondStack = new Stack();

        // while (holdX > 0) {
        //     int getLast = holdX % 10;
        //     firstStack.push(getLast);
        //     holdX = holdX / 10;
        // }

        // int stackSize = firstStack.size();
        // int stackSizeHalved = stackSize / 2;

        // for (int i = stackSizeHalved; i > 0; i--) {
        //     secondStack.push(firstStack.pop());
        // }

        // if (stackSize % 2 != 0) {
        //     firstStack.pop();
        // }
    
        // for (int i = stackSizeHalved; i > 0; i--) {
        //     if (firstStack.pop() != secondStack.pop()) {
        //         return false;
        //     }
        // }

        // return true;
    }
}
