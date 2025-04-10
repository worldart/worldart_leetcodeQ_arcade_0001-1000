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
    public int level = 0, min = Integer.MAX_VALUE;
    public void getMin(TreeNode root) {
        ++level;
        if (level == min) {
            --level;
            return;
        }
        if (root.left == null && root.right == null) {
            min = Math.min(level, min);
            --level;
            return;
        }
        if ((root.left != null) && (root.right == null || root.right.right != null || root.right.left != null)) getMin(root.left);
        if (root.right != null) getMin(root.right);
        --level;
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        getMin(root);
        return min;
    }
}
