//3ms 84.42%RT


class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int index = 0;
        for( int num : nums ){
            if( index < 2 || num != nums[index - 2] )
                nums[index++] = num;
        }
        return index;
    }
};
