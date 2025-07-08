//0ms




class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxi = INT_MIN;
        int prod=1;

        for(int i=0;i<nums.size();i++)
        {
          prod*=nums[i];
          maxi=max(prod,maxi);
          if(prod==0)
           prod=1;
        }
        prod=1;
        for(int i=nums.size()-1;i>=0;i--)
        {
          prod*=nums[i];

          maxi=max(prod,maxi);
          if(prod==0)
           prod=1;
        }
        return maxi;
    }
};





//0ms





class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int res = nums[0];
        int minProduct = nums[0];
        int maxProduct = nums[0];
        for(int i = 1; i < nums.size(); i++) {
            //cout << minProduct << ", " << maxProduct << ", " << res << endl;
            if(nums[i] < 0) {
                swap(minProduct, maxProduct);
            } 
            
            minProduct = min(minProduct * nums[i], nums[i]);
            maxProduct = max(maxProduct * nums[i], nums[i]);
            res = max(res, maxProduct);
            //cout << minProduct << ", " << maxProduct << ", " << res << endl;
        }
        return res;
    }
};
