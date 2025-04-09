//1ms

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
 * @return {boolean}
 */
var isBalanced = function (root) {
    const dfs = (root) => {
        if (!root) {
            return 0
        }
        let l = dfs(root.left)
        if(l === -1) {
            return -1
        }
        let r = dfs(root.right)
        if(r === -1) {
            return -1
        }
        let diff = Math.abs(l - r)
        if (diff <= 1) {
            return Math.max(l, r) + 1
        } else {
            return -1
        }
    }
    return dfs(root) !== -1
};
