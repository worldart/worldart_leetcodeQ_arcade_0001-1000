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
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, sum, res = [], path = []){
    if(root){
        path.push(root.val);
        if(!root.left && !root.right && sum - root.val === 0) res.push([...path]);
        pathSum(root.left, sum - root.val, res, path);
        pathSum(root.right, sum - root.val, res, path);
        path.pop();
    }
    return res;
};
