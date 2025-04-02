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
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
const build = (postorder, inorderMap, indexObj, start = 0, end = 0) => {
  if (start > end) return null;
  const rootVal = postorder[indexObj.value--];
  const root = new TreeNode(rootVal);
  const inorderI = inorderMap.get(rootVal);
  root.right = build(postorder, inorderMap, indexObj, inorderI + 1, end);
  root.left = build(postorder, inorderMap, indexObj, start, inorderI - 1);
  return root;
};

var buildTree = function (inorder, postorder) {
  const inorderMap = new Map();
  for (let i = 0; i < inorder.length; i++) inorderMap.set(inorder[i], i);
  const indexObj = { value: postorder.length - 1 };
  return build(postorder, inorderMap, indexObj, 0, inorder.length - 1);
};
