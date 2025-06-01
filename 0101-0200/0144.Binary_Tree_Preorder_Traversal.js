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
var preorderTraversal = function (root) {
  const preOrder = [];

  const DFS = (node) => {
    if (!node) return;
    preOrder.push(node.val);
    DFS(node.left);
    DFS(node.right);
  };

  DFS(root);
  return preOrder;
};
