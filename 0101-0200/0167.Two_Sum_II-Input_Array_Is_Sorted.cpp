//0ms





class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int n=numbers.size();
        int i=0,j=n-1,sum=0;
        while(i<j){
            sum=numbers[i]+numbers[j];
            if(sum==target) return {i+1, j+1};
            else if(sum<target){
            i ++;}
            else{
            j -- ;}
            }
        
      return {};
    }
};





//0ms





class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int index1 = 0; 
        int index2 = numbers.size()-1;
        int sum = numbers[index1] + numbers[index2];
        while (sum != target) {
            if (sum > target) {
                index2--;
            } else {
                index1++;
            }
            sum = numbers[index1] + numbers[index2];
        }
        return {index1+1, index2+1};
    }
};
