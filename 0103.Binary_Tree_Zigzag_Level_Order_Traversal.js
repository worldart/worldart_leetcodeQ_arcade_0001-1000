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
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var zigzagLevelOrder = function (root) {
    if (!root) return [];
    const que = [root];
    const res = [];
    let flag = true;

    while (true) {
        if (que.length === 0) break;
        const currLevel = [];
        const len = que.length;
        for (let i = 0; i < len; i++) {
            let temp = que.shift();
            if (temp) {
                currLevel.push(temp.val);
                if (temp.left) que.push(temp.left);
                if (temp.right) que.push(temp.right);
            }
        }
        if (flag) {
            res.push(currLevel);
        } else {
            res.push(currLevel.reverse());
        }
        flag = !flag;
    }
    return res;
};
