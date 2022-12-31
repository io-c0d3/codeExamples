/**
 *
 * Given a binary tree, determine if it is height-balanced.
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
// I needed to use a solution to figure this one out. I couldnt really make sense of it.
class Solution {

    public boolean isBalanced(TreeNode root) {
        // If the Tree is empty, it is balanced.
        if (root == null) return true;
        if (recursion(root) == -1) return false;
        return true;
    }

    private int recursion(TreeNode node) {
        // If the node doesnt exist, it doesnt add to the depth count.
        if (node == null) return 0; 
        // Get the depth of each pair of nodes.
        int leftHeight = recursion(node.left);
        int rightHeight = recursion(node.right);
        // If either of the sub nodes have a depth difference greater than 1, return -1.
        if (leftHeight == -1 || rightHeight == -1) return -1;
        // If the nodes have a depth difference of more than 1, return -1.
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        // Return the greater of the two sub node depths, plus 1.
        return Math.max(leftHeight, rightHeight) + 1;
        
    }
}
