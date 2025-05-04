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
 * @return {number}
 */
var maxPathSum = function (root) {
    let max = -Infinity

    if(root === null){
        return 0
    }

    function helper(root) {
        if (root === null) {
            return 0
        }

        const left = Math.max(0, helper(root.left))
        const right = Math.max(0, helper(root.right))

        max = Math.max(left + right + root.val, max)
        return Math.max(left, right) + root.val
    }

    helper(root)
    return max

};
