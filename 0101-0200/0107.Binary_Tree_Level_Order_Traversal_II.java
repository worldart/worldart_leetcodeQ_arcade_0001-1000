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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();
        levelOrder(root,1,l);
        return l;
    }
    private void levelOrder(TreeNode root,int level,List<List<Integer>> l){
        if(root==null){
            return;
        }
        if(l.size()<level){
            l.add(0,new ArrayList<>());
        }
        l.get(l.size()-level).add(root.val);
        levelOrder(root.left,level+1,l);
        levelOrder(root.right,level+1,l);
        return;
    }
}
