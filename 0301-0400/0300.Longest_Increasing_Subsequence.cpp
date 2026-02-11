//3ms




class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        // temp[i] = smallest element as the tail of a LSIS of length i + 1
        vector<int> temp;
        temp.push_back(nums[0]);
        for(int i = 0; i < nums.size(); i += 1){
            if(nums[i] > temp.back()) temp.push_back(nums[i]);
            else *lower_bound(begin(temp), end(temp), nums[i]) = nums[i];
        }
        return temp.size();
    }
};




//Binaty indexed tree 4ms






class MaxBIT {
    vector<int> bit;
public:
    MaxBIT(int size) {
        bit.resize(size + 1);
    }
    int get(int idx) {
        int ans = 0;
        for (; idx > 0; idx -= idx & -idx)
            ans = max(ans, bit[idx]);
        return ans;
    }
    void update(int idx, int val) {
        for (; idx < bit.size(); idx += idx & -idx)
            bit[idx] = max(bit[idx], val);
    }
};
class Solution { // 12 ms, faster than 75.90%
public:
    int lengthOfLIS(vector<int>& nums) {
        int nUnique = compress(nums);
        MaxBIT bit(nUnique);
        for (int x : nums) {
            int subLongest = bit.get(x - 1);
            bit.update(x, subLongest + 1);
        }
        return bit.get(nUnique);
    }
    int compress(vector<int>& arr) {
        vector<int> uniqueSorted(arr);
        sort(uniqueSorted.begin(), uniqueSorted.end());
        uniqueSorted.erase(unique(uniqueSorted.begin(), uniqueSorted.end()), uniqueSorted.end()); // Remove duplicated values
        for (int& x : arr) x = lower_bound(uniqueSorted.begin(), uniqueSorted.end(), x) - uniqueSorted.begin() + 1;
        return uniqueSorted.size();
    }
};





//Binaty indexed tree 6ms






class MaxBIT { // One-based indexing
    vector<int> bit;
public:
    MaxBIT(int size) {
        bit.resize(size + 1);
    }
    int get(int idx) {
        int ans = 0;
        for (; idx > 0; idx -= idx & -idx)
            ans = max(ans, bit[idx]);
        return ans;
    }
    void update(int idx, int val) {
        for (; idx < bit.size(); idx += idx & -idx)
            bit[idx] = max(bit[idx], val);
    }
};
class Solution { // 16 ms, faster than 72.16%
public:
    int lengthOfLIS(vector<int>& nums) {
        int BASE = 10001;
        MaxBIT bit(20001);
        for (int x : nums) {
            int subLongest = bit.get(BASE + x - 1);
            bit.update(BASE + x, subLongest + 1);
        }
        return bit.get(20001);
    }
};
