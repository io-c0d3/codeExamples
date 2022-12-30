/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
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

// I had to use a bit of a guide to understand how to do this. The solution is really straightforward
// but ive never done anything like this. The power of recursion :)
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // If the input array is empty return null as there isnt a root node.
        if (nums.length == 0) return null;
        // Get the center position of the array.
        int halfway = nums.length / 2;
        // Create a new TreeNode using the halfway point of the sub/array.
        TreeNode root = new TreeNode(nums[halfway]);
        // Set the .left and .right values of root using recursion on the right and left halves of the input array.
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, halfway));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, halfway + 1, nums.length));
        // Return the completed height-balanced BST.
        return root;
    }
}
