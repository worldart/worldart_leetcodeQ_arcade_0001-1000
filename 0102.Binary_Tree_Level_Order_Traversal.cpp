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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if (root == nullptr)
            return ans;

        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            vector<int> temp;
            int n = q.size();


               for (int i = 0; i < n; i++) {
                TreeNode* ptr = q.front();
                q.pop();
                temp.push_back(ptr->val);
                if (ptr->left)
                    q.push(ptr->left);
                if (ptr->right)
                    q.push(ptr->right);
                }


            ans.push_back(temp);
        }
        return ans;
    }
};
