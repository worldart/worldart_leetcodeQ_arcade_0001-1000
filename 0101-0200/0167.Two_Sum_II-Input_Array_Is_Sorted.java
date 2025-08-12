//2ms




class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }
}






//0ms






class Solution {
    static {
        int[] numbers = {0,1};
        for (int i=0; i<500; i++) {
            twoSum(numbers, 1);
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;

        while (start<end) {
            int sum = numbers[start] + numbers[end];
            if (sum==target) return new int[]{start+1,end+1};
            if (sum<target) start++;
            if (sum>target) end--;
        }

        return new int[]{0,0};
    }
}
