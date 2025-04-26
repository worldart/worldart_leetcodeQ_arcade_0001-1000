//0ms


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        return helper(triangle, 0)[0];
    }

    int[] helper(List<List<Integer>> triangle, int p) {
        
        if(p == triangle.size()) {
            return new int[triangle.get(p-1).size()+1];
        }
        int down[] = helper(triangle, p+1);

        int ans[] = new int[triangle.get(p).size()];
        List<Integer> list = triangle.get(p);
        for(int i =0;i<ans.length;i++) {
            ans[i] = list.get(i)+Math.min(down[i], down[i+1]);
        }
        return ans;
    }
}
