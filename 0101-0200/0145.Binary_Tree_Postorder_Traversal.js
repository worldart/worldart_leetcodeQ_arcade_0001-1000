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
 * @return {number[]}
 */

const postorderTraversal = (root) => {
    const result = [];
    if (!root) return result;

    const stack = [];
    let current = root;
    let lastVisited = null;

    while (stack.length || current) {
        if (current) {
            stack.push(current);
            current = current.left;
        } else {
            const peekNode = stack[stack.length - 1];
            if (peekNode.right && lastVisited !== peekNode.right) {
                current = peekNode.right;
            } else {
                result.push(peekNode.val);
                lastVisited = peekNode;
                stack.pop();
            }
        }
    }

    return result;
};
