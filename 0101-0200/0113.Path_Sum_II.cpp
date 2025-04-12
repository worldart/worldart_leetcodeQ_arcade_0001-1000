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
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> ans;
        vector<int> temp;
        checkhastargetSum(root , targetSum,temp,ans);
        return ans;
    }
    void checkhastargetSum(TreeNode* root, int targetSum, vector<int> &temp, vector<vector<int>> &ans)
    {
        if(root==nullptr)
        return ;
        temp.push_back(root->val);
        targetSum-=root->val;
        if(root->left==nullptr&&root->right==nullptr&&targetSum==0)
        {
            ans.push_back(temp);
        }
        checkhastargetSum(root->left, targetSum,temp,ans);
        checkhastargetSum(root->right, targetSum,temp,ans);
        temp.pop_back();

    }
};
