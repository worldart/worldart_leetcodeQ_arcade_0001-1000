//0ms


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
var flatten = function(root) {
    
    let prev = null;
    
    var helper = function( node ){
        
        if( node != null){
            
            // DFS travesal to next level
            helper(node.right);
            helper(node.left);
            
            // flattern binary tree to right skewed linked list
            node.right = prev;
            node.left = null
            prev = node
        }
        return;
    }
    // ------------------------------------
    
    helper( root );
};
