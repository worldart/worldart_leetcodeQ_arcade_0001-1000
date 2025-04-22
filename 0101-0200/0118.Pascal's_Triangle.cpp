//0ms


class Solution {
public:
// add function
    void add(int x,vector<vector<int>>&res){
        if(x==2)return;
        vector<int>tmp={1};
        int f=res.size()-1;
        for(int i=0;i<res[f].size()-1;i++){
            int num=res[f][i]+res[f][i+1];
            tmp.push_back(num);
        }
        tmp.push_back(1);
        res.push_back(tmp);
        add(x-1,res);
    }
    vector<vector<int>> generate(int n) {
        if(n==1)return{{1}};
        if(n==2)return{{1},{1,1}};
        vector<vector<int>>res={{1},{1,1}};
        add(n,res);
        return res;
    }
};
