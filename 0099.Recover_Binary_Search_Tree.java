//1ms

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
       TreeNode first ;
        TreeNode middle;
        TreeNode last;
        TreeNode prev;
    public void recoverTree(TreeNode root) {
        first = null;
         middle = null;
         last = null;
         prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        //If i got two violations that is i have first and last so swap that
        if(first!=null && last!=null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        //If i got only one violations that is only first so swapping that with middle will correct out inorrder traversal result
        else if(first!=null && middle!=null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    public void inorder(TreeNode root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        //Perform functons
        
        if(prev!=null && (root.val < prev.val)){
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }
        } 
        prev=root;
        inorder(root.right);
    }
}
