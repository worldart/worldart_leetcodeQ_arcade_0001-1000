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
 * @return {number[][]}
 */
var levelOrderBottom = function(root) {
    // BFS
    if(!root) {
        return [];
    }
    let result = [];
    let queue = [root];

    while(queue.length) {
        const size = queue.length;
        let res = [];
        for(let i = 0; i < size; i++) {
            let node = queue.shift();
            res.push(node.val);
            if(node.left) queue.push(node.left);
            if(node.right) queue.push(node.right);
        }
        result.unshift(res);
    }

    return result;
};
