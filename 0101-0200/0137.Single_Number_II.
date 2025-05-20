//3ms


class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unordered_map<int, int> m;
        
        for(auto x: nums){
            m[x]++;
        }

        for(auto x: m){
            if(x.second == 1){
                return x.first;
            }
        }
        
        return -1;
    }
};




//4ms




class Solution {
public:
    int singleNumber(vector<int>& nums) {
        std::unordered_map<int, int> dict;
        for (int i = 0; i < nums.size(); ++i) {
            dict[nums[i]] ++;
        }
        for (auto elem : dict) {
            if (elem.second == 1) return elem.first;
        }
        return 0;
    }
};





//2ms





class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int bt[31];
   
    for(int i=0;i<31;i++)bt[i]=0;
    int ps=0,ng=0,bg=0;
    for(auto &a: nums){
        
        if(a==-2147483648)bg++;
        else if(a<0)ng++,a=a*(-1);
        else ps++;
        for(int j=0;j<31;j++){
            if(a&(1<<j)){
                bt[j]++;
            }
        }
    }
    if(bg%3){
        return  -2147483648;
    }

    int num=0;
    
    for(int i=0;i<31;i++){
        if(bt[i]%3!=0)num|=(1<<i);
    }
    
    
    if(ps%3)return num;
    else return -num;
    }
};





//0ms






class Solution {
public:
 int singleNumber(vector<int>& nums) {
  int ones = 0, twos = 0;
  for (int num : nums) {
   ones = (ones ^ num) & ~twos;
   twos = (twos ^ num) & ~ones;
  }
  return ones;
 }
};



//0ms same as above


#include <vector>
using namespace std;
class Solution {
public:
 int singleNumber(vector<int>& nums) {
  int ones = 0, twos = 0;
  for (int num : nums) {
   ones = (ones ^ num) & ~twos;
   twos = (twos ^ num) & ~ones;
  }
  return ones;
 }
};
