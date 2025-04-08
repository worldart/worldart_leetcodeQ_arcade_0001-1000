//2ms 98.46%

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function(root) {
    let first = null;
    let last = null;
    let prev = null;
    
	// Inorder traversal to track the first and last violation of order
    function dfs (node) {
        if (!node) return;
        
        dfs (node.left);
        
        if (prev && node.val < prev.val){
            if (first === null) first = prev;
            
            last = node;
        }
        prev = node;
        
        dfs (node.right);
    }
    dfs(root, null)
    
    let temp = first.val;
    first.val = last.val;
    last.val = temp
  
    return root;
};
