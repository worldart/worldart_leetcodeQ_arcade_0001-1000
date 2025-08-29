//11ms






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
class BSTIterator {
public:
    vector<int> ans;
    int i = 0;

    BSTIterator(TreeNode* root) {
        inorder(root);
    }

    void inorder(TreeNode* root) {
        if (!root) return;
        inorder(root->left);
        ans.push_back(root->val);
        inorder(root->right);
    }

    int next() {
        return ans[i++];
    }

    bool hasNext() {
        return i <= ans.size() - 1;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */






//9ms






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
class BSTIterator {
public:
    stack<TreeNode*> st;
    void storeLeft(TreeNode* root){
        while(root!=NULL){
            st.push(root);
            root = root->left;
        }
    }
    BSTIterator(TreeNode* root) {
        storeLeft(root);
    }
    
    int next() {
        TreeNode* ans = st.top();
        st.pop();
        storeLeft(ans->right);
        
        return ans->val;
    }
    
    bool hasNext() {
        return st.size()>0;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
