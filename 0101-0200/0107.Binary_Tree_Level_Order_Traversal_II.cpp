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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        if (!root) return {};

        vector<vector<int>> levels;
        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            int levelSize = q.size();
            vector<int> level;

            for (int i = 0; i < levelSize; ++i) {
                TreeNode* currentNode = q.front();
                q.pop();

                if (currentNode->left) q.push(currentNode->left);
                if (currentNode->right) q.push(currentNode->right);

                level.push_back(currentNode->val);
            }

            levels.push_back(level);
        }

        reverse(levels.begin(), levels.end());
        return levels;
    }
};
