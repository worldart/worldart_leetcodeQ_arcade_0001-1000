//0ms





/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        if (!root) return result;
        
        stack<TreeNode*> s;
        s.push(root);

        while (!s.empty()) {
            TreeNode* root = s.top(); // Access the current node
            result.push_back(root->val);
            s.pop(); // Remove it from the stack

            if (root->right)
                s.push(root->right); // Right pushed first
            if (root->left)
                s.push(root->left); // Left pushed last (processed first)
        }

        return result;
    }
};





//0ms




/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        dfs(root, result);
        return result;
    }
    
    void dfs(TreeNode* node, vector<int>& result) {
        if (!node) return;
        result.push_back(node->val); // Visit root
        dfs(node->left, result);     // Traverse left subtree
        dfs(node->right, result);    // Traverse right subtree
    }
};

