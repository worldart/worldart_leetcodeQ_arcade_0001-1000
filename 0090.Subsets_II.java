//1ms 99.84%RT 20250314

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  
        backtrack(new ArrayList<>(), 0, nums);
        return res;
    }

    public void backtrack(List<Integer> path, int st, int[] nums){
        res.add(new ArrayList<>(path));  

        for (int i = st; i < nums.length; i++){
            if (i > st && nums[i] == nums[i - 1]){
                continue;  
            }
            path.add(nums[i]);
            backtrack(path, i + 1, nums);
            path.remove(path.size() - 1); 
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
