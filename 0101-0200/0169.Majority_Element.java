//0ms







class Solution {
    public static int majorityElement(int[] nums) {
        return helper(nums,0,nums[0]);
    }static int helper(int[] nums, int si, int ref){
        int c=0;
        for(int i=si;i<nums.length;i++){
            if(nums[i]==ref)
                c++;
            else
                c--;
            if(c==-1)
                return helper(nums,i,nums[i]);
        }return ref;
    }
}







//1ms





class Solution {
    public int majorityElement(int[] nums) {
       int element=0;// store majority element
       int count=0;  //counter

// Traverse the array to find the majority element
       for(int i=0; i<nums.length; i++){
        if(count==0){
// Adopt a new element
            element= nums[i];
        }
        if(element== nums[i]) count++;   //increment if element is same
        else count--;  //decrement id different, to adopt new element
       }

        // Since majority element is guaranteed to exist,
       return element;
    }
}  
