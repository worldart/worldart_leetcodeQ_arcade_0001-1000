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
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
  let preNdx = 0;
  let inNdx = 0;

  function dfs(limit) {
    if (preNdx >= preorder.length) return null;
    if (inorder[inNdx] === limit) {
      inNdx++;
      return null;
    }

    const root = new TreeNode(preorder[preNdx++]);

    root.left = dfs(root.val);
    root.right = dfs(limit);

    return root;
  }

  return dfs(Infinity);
};
