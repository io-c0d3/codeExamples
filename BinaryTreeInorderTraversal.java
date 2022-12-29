/**
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

 // I had to do a bit of research for this one, ive never had to deal with binary tree
 // traversal before.
class Solution {
    // Create a list to hold all of the values in, outside of the recursive method.
    List<Integer> newList = new ArrayList<Integer>();
    // Recursive method to conduct a Binary Tree Inorder Traversal.
    public List<Integer> inorderTraversal(TreeNode root) {
        // If the tree root is empty return the list.
        if (root == null) return newList;
        // If the root has a left node, go to it recursively.
        if (root.left != null) inorderTraversal(root.left);
        // Adds all left nodes to the list before returning back to the right nodes and adding them.
        newList.add(root.val);
        // If the root has a right node, go to it recursively.
        if (root.right != null) inorderTraversal(root.right);
        
        return newList;
    }
}
