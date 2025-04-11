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
 * @return {boolean}
 */
var hasPathSum = function(root, targetSum) {
    const dfs = (root, sum, target) => {
        if (!root)
            return false
        sum += root.val
        if (sum == target && !root.left && !root.right)
            return true
        
        return dfs(root.right, sum, target) || dfs(root.left, sum, target)
    }

    return dfs(root, 0, targetSum)
};
