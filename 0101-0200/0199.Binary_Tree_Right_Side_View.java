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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        int level = Levels(root);
        for(int i = 0 ; i < level ; i++){
            ans.add(0);
        }
        preOrder(root,0,ans);
        return ans;
    }
    private void preOrder(TreeNode root , int level , ArrayList<Integer> ans){
        if(root == null) return ;
        ans.set(level,root.val);
        preOrder(root.left , level+1 , ans);
        preOrder(root.right , level+1 , ans);
    }
    private int Levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(Levels(root.left),Levels(root.right));
    }
}





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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traverse(root, result, 0);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result, int depth) {
        if (node == null) return;

        if (depth >= result.size()) {
            result.add(node.val);
        } else {
            result.set(depth, node.val);
        }

        traverse(node.left, result, depth+1);
        traverse(node.right, result, depth+1);
    }
}
