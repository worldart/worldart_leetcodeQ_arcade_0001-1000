//0MS

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

    int findDepth(TreeNode* &root, bool &isBalanced) {
        // bc
        if (!root) return 0;

        int left = findDepth(root->left, isBalanced);
        int right = findDepth(root->right, isBalanced);
        // check for curr node is balanced
        if (isBalanced && abs(left - right) > 1) isBalanced = false;
        
        return max(left, right) + 1;
    }

    bool isBalanced(TreeNode* root) {
        // // 01 approach - o(n2)
        // // bc
        // if (!root) return true;

        // // left subtree
        // bool op3 = (abs(findDepth(root->left)-findDepth(root->right)) <= 1) ? true : false;
        // bool op1 = isBalanced(root->left);
        // bool op2 = isBalanced(root->right);

        // return (op1 && op2 && op3);

        // 02 approach - o(n)
        bool isBalanced = true;
        findDepth(root, isBalanced);
        return isBalanced;
    }
};
