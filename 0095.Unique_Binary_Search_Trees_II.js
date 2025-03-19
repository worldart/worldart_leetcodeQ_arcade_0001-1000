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
 * @param {number} n
 * @return {TreeNode[]}
 */
let dp = {};

const genAllTrees = (left,right)=>{
    if(left>right) return [null]
    if(dp[left+","+right]) return dp[left+","+right]

    let res =[]
    for(var root = left;root<=right;root++){
        let leftTrees = genAllTrees(left,root-1)
        let rightTrees = genAllTrees(root+1,right)

        for(l of leftTrees){
            for(r of rightTrees){
                let node = new TreeNode(root,l,r)
                res.push(node)
            }
        }
    }
    dp[left+","+right] = res
    return res
}

var generateTrees = function(n) {
    
    return genAllTrees(1,n)
    
};
