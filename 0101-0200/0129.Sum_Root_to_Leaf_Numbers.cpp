//0ms

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
   void find(TreeNode* root,long long rem,int& ans){
    if(!root){
        return;
    }
    if(!root->left && !root->right){
        rem=rem*10+root->val;
        ans+=rem;
    }
    rem=rem*10+root->val;
    find(root->left,rem,ans);
    find(root->right,rem,ans);
   }
    int sumNumbers(TreeNode* root) {
        int ans=0;
        long long rem=0;
        find(root,rem,ans);
        return ans;
      
        
    }
};
