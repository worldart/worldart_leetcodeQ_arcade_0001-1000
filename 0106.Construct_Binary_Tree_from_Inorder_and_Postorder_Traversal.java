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
    int in; // Start from beginning
    int post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = post; // Start from the last element of postorder
        return tree(inorder, postorder, Integer.MIN_VALUE);
    }

    public TreeNode tree(int[] inorder, int[] postorder, int stop) {
        if (post < 0) return null;
        if (stop == inorder[in]) {
            --in;
            return null;
        }
        TreeNode node = new TreeNode(postorder[post--]); // Take the last element as root
        node.right = tree(inorder, postorder, node.val); // Build right subtree first
        node.left = tree(inorder, postorder, stop); // Then build left subtree
        return node;
    }
}
