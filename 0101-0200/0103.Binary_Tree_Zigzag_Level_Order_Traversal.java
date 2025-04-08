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
 
 public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        oie(root, res,0);
        return res;
    }

    public void oie(TreeNode node, List<List<Integer>> res, int level)
    {
        if(node==null)   return;

        if(res.size()<=level)
        {
            res.add(new LinkedList<>());
        }
         List<Integer> commando = res.get(level);

         if(level%2 == 0)
         {
            commando.add(node.val);
         }
         else{
            commando.add(0,node.val);
         }

         oie(node.left,res,level+1);
         oie(node.right, res, level+1);
    }
 }














//  public class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> sol = new ArrayList<>();
//         travel(root, sol, 0);
//         return sol;
//     }

//     private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
//         if (curr == null) return;
        
//         if (sol.size() <= level) {
//             sol.add(new LinkedList<>());
//         }
        
//         List<Integer> collection = sol.get(level);
        
//         if (level % 2 == 0) {
//             collection.add(curr.val);
//         } else {
//             collection.add(0, curr.val);
//         }

//         travel(curr.left, sol, level + 1);
//         travel(curr.right, sol, level + 1);
//     }

//  }
