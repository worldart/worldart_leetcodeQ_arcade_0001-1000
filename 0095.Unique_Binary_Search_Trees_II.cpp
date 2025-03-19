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
    vector<TreeNode*> allPossibleBSTs(map<pair<int,int>, vector<TreeNode*>> &dp, int start, int end)
    {
        vector<TreeNode*> res;
        if(start > end)
        {
            res.push_back(nullptr);
            return res;
        }

        if(dp.find(make_pair(start, end)) != dp.end())
        {
            return dp[make_pair(start,end)];
        }

        for(int i = start; i <= end; i++)
        {
            vector<TreeNode*> leftTrees = allPossibleBSTs(dp, start, i-1 );
            vector<TreeNode*> rightTrees = allPossibleBSTs(dp, i+1, end);

            for(auto left:leftTrees)
            {
                for(auto right:rightTrees)
                {
                    TreeNode* temp = new TreeNode(i, left, right);
                    res.push_back(temp);
                }
            }
        }

        return dp[make_pair(start, end)] = res;
    }
    vector<TreeNode*> generateTrees(int n) {
        map<pair<int,int>, vector<TreeNode*>> dp;
        return allPossibleBSTs(dp, 1, n);
    }
};
