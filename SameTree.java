/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Store a number that wont be found within the tree.
    private int outsideBounds = -10001;
    // Create two ArrayLists to hold the Integer values of each node.
    List<Integer> firstList = new ArrayList<Integer>();
    List<Integer> secondList = new ArrayList<Integer>();
    // Method to check if two trees are the same.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Use recursive method to check if both trees are the same.
        traverse(p, firstList);
        traverse(q, secondList);
        // Compare the two ArrayLists, if they are the same return true, else false.
        if (firstList.equals(secondList)) return true;
        return false;
    }
    // Recursive method to get the values of each node on the tree and add them to a List.
    private void traverse(TreeNode root, List list) {
        // If the node doesnt exist, return.
        if (root == null){
            return; 
        } 
        // If the left node is not null, add -99 to the list and then recursively call this method. Adding
        // the -10001 means we keep track of every time the method goes left, so even if we have tricky trees that
        // create an incredibly similar result, we know if the shape is the same as well as the resulting values.
        if (root.left != null){
            list.add(outsideBounds);
            traverse(root.left, list);
        } 
        // Add the value of the node.
        list.add(root.val);
        // If there is a right node to traverse after all of the available left nodes, recursively call this method.
        if (root.right != null) traverse(root.right, list);
        return;
    }
}
