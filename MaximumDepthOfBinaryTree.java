/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
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
    // Integer to hold the maximum depth counted.
    private int maxCount = 0;
    // Main solution method, returns the depth of the tree which is counted by a recursive method.
    public int maxDepth(TreeNode root) {
        // If the tree root is null, return a depth of 0.
        if (root == null) return 0;
        // Call the recursive method.
        depth(root, 0);
        // Return the maximum depth counted.
        return maxCount;
    }
    // Recursive method to count the depth of the tree.
    private void depth(TreeNode node, int counter) {
        // Increase the depth counter every time we go down a node.
        counter++;
        // Call this method recursively.
        if (node.left != null) depth(node.left, counter);
        if (node.right != null) depth(node.right,counter);
        // If the current depth is greater than the current maximum depth counted, update the maximum depth count.
        if (counter > maxCount) maxCount = counter;
    }
}
