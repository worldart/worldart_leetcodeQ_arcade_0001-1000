//0ms
//Iterative solution using stack



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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> nodes;
        stack<TreeNode*> todo;
        TreeNode* last = NULL;
        while (root || !todo.empty()) {
            if (root) {
                todo.push(root);
                root = root -> left;
            } else {
                TreeNode* node = todo.top();
                if (node -> right && last != node -> right) {
                    root = node -> right;
                } else {
                    nodes.push_back(node -> val);
                    last = node;
                    todo.pop();
                }
            }
        }
        return nodes;
    }
};






//0ms
//Recursive solution




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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> nodes;
        postorder(root, nodes);
        return nodes;
    }
private:
    void postorder(TreeNode* root, vector<int>& nodes) {
        if (!root) {
            return;
        }
        postorder(root -> left, nodes);
        postorder(root -> right, nodes);
        nodes.push_back(root -> val);
    }
};







//0ms
//Morris traversal






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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> nodes;
        TreeNode* dummy = new TreeNode(0);
        dummy -> left = root;
        TreeNode* cur = dummy;
        while (cur) {
            if (cur -> left) {
                TreeNode* pre = cur -> left;
                while (pre -> right && (pre -> right != cur)) {
                    pre = pre -> right;
                }
                if (!(pre -> right)) {
                    pre -> right = cur;
                    cur = cur -> left;
                } else {
                    reverseAddNodes(cur -> left, pre, nodes);
                    pre -> right = NULL;
                    cur = cur -> right;
                }
            } else {
                cur = cur -> right;
            }
        }
        return nodes;
    }
private:
    void reverseNodes(TreeNode* start, TreeNode* end) {
        if (start == end) {
            return;
        }
        TreeNode* x = start;
        TreeNode* y = start -> right;
        TreeNode* z;
        while (x != end) {
            z = y -> right;
            y -> right = x;
            x = y;
            y = z;
        }
    }
    void reverseAddNodes(TreeNode* start, TreeNode* end, vector<int>& nodes) {
        reverseNodes(start, end);
        TreeNode* node = end;
        while (true) {
            nodes.push_back(node -> val);
            if (node == start) {
                break;
            }
            node = node -> right;
        }
        reverseNodes(end, start);
    }
};
