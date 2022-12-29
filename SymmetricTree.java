/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
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
 // My solution is quite slow and a lot more complicated than it needs to be when looking at the other
 // solutions. I think I got a bit too focused on the whole traversal to a list thing.
class Solution {
    // Create ArrayLists to hold the two sides of the tree.
    List<Integer> leftList = new ArrayList<Integer>();
    List<Integer> rightList = new ArrayList<Integer>();
    // Integers to hold values I will use to mark movements left and right, or null node.val values.
    private int outsideBounds1 = -101;
    private int outsideBounds2 = 101;
    private int notAndNullPair = 10000;
    // Method that calls the recursive method and returns whether the tree is symmetrical or not.
    public boolean isSymmetric(TreeNode root) {
        // Recursive calls.
        left(root.left);
        right(root.right);

        if (leftList.equals(rightList)) return true;
        return false;
    }

    // Recursive method for the left side of the tree.
    private void left(TreeNode node) {
        // If node is null, return.
        if (node == null) return;
        // Add node.val to appropriate list.
        leftList.add(node.val);
        // If a node is null and its sibling isnt, add the placeholder value notNullAndPair.
        if (node.right == null && node.left != null) {
            leftList.add(notAndNullPair);
        }
        // Call recursively, adding the placeholder that indicates a move outwards.
        if (node.left != null) {
            leftList.add(outsideBounds1);
            left(node.left);
        } 
        // Call recursively, adding the placeholder that indicates a move inwards.
        if (node.right != null) {
            leftList.add(outsideBounds2);
            left(node.right);
        }
        return;
    }

    // Recursive method for the right side of the tree.
    private void right(TreeNode node) {
        // If node is null, return.
        if (node == null) return;
        // Add node.val to appropriate list.
        rightList.add(node.val);
        // If a node is null and its sibling isnt, add the placeholder value notNullAndPair.
        if (node.left == null && node.right != null) {
            rightList.add(notAndNullPair);
        }
        // Call recursively, adding the placeholder that indicates a move outwards.
        if (node.right != null) {
            rightList.add(outsideBounds1);
            right(node.right);
        }
        // Call recursively, adding the placeholder that indicates a move inwards.
        if (node.left != null) {
            rightList.add(outsideBounds2);
            right(node.left);
        }
        return;
    }


}
