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
 * @return {number}
 */
var minDepth = function (root) {
    if(!root) return 0;
  const queue = [{ cur: root, deep: 1 }];


  while (true) {
    const { cur, deep } = queue.shift();

    if (cur.left) queue.push({ cur: cur.left, deep: deep + 1 });
    if (cur.right) queue.push({ cur: cur.right, deep: deep  +1 });

    if (!cur.left && !cur.right) return deep;
  }
};
