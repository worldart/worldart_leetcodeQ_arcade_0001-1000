


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
//0ms
import java.util.*;
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return new AbstractList<>(){
            private List<List<Integer>> ans = null;
            @Override
            public int size(){
                if(ans == null) ans = solve(root , targetSum);
                return ans.size();
            }

            @Override 
            public List<Integer> get(int index){
                if(ans == null) ans = solve(root , targetSum);
                return ans.get(index);
            }
        };
    }

    private List<List<Integer>> ans;
    private List<List<Integer>> solve(TreeNode root , int targetSum){
        this.ans = new ArrayList<>();
        if(root == null) return ans;
        helper(root , 0 , targetSum , new ArrayList<>());
        return ans;
    }

    private void helper(TreeNode root , int sum , int targetSum , List<Integer> temp){
        if(root == null) return;
        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == targetSum) ans.add(new ArrayList<>(temp));
            return;
        }
        if(root.left != null){
            helper(root.left , sum , targetSum , temp);
            temp.remove(temp.size() - 1);
        }
        if(root.right != null){
            helper(root.right , sum , targetSum , temp);
            temp.remove(temp.size() - 1);
        }
    }
}
/*
//1ms
class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.list = new ArrayList<>();
        solve(root , 0 , targetSum , new ArrayList<>());
        return list;
    }
    private void solve(TreeNode root , int sum , int targetSum , List<Integer> temp){
        if(root == null) return;
        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == targetSum) list.add(new ArrayList<>(temp));
            return;
        }
        if(root.left != null){
            solve(root.left , sum , targetSum , temp);
            temp.remove(temp.size() - 1);
        }
        if(root.right != null){
            solve(root.right , sum , targetSum , temp);
            temp.remove(temp.size() - 1);
        }
    }
}
 */
