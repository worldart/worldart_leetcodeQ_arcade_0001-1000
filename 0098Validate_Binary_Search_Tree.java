//0ms


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
class Solution {
    // Global variable to store the previous node value in inorder traversal
    long min = Long.MIN_VALUE;

    // Helper function to validate BST using inorder traversal
    private boolean isValid(TreeNode root) {
        // Base case: If the node is null, it's a valid BST
        if (root == null) {
            return true;
        }

        // Recursively check the left subtree
        boolean left = isValid(root.left);
        // If the left subtree is invalid, return false immediately
        if (!left) return false;

        // Check if the current node violates BST property
        if (root.val <= min) {
            return false; // BST rule violated, return false
        }

        // Update the min value to the current node's value
        min = root.val;

        // Recursively check the right subtree
        boolean right = isValid(root.right);

        // Return the result of right subtree check
        return right;
    }

    // Main function to check if a tree is a valid BST
    public boolean isValidBST(TreeNode root) {
        return isValid(root); // Start checking from the root
    }
}
