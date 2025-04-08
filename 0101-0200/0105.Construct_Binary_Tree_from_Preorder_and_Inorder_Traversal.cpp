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
    TreeNode *tree(unordered_map<int,int> &m,vector<int> &p,int i,int j,int &k)
    {
        if(i>j)
            return NULL;
        int n=p[k++];
        TreeNode *root=new TreeNode(n);
        root->left=tree(m,p,i,m[n]-1,k);
        root->right=tree(m,p,m[n]+1,j,k);
        return root;
    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) 
    {
        unordered_map<int,int> m;
        for(int i=0;i<inorder.size();i++)
            m[inorder[i]]=i;
        int k=0;
        return tree(m,preorder,0,inorder.size()-1,k);
    }
};
