//2ms 66.79% 20250329


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

var levelOrder = function(root) {
    if(!root) return [];
    let levels = [];
    let queue = [root];
    while (queue.length) {
        let level = [];
        let queueSize = queue.length;
        while(queueSize) {
            const item = queue.shift();
            level.push(item.val);
            if(item.left) queue.push(item.left);
            if(item.right) queue.push(item.right);
            queueSize--;
        }
        levels.push(level); 
    };
    return levels;
};
