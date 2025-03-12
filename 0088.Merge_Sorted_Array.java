//1ms


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}


/*

//0ms


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0) {
            if(nums1[m] > nums2[n]) {
                nums1[idx--] = nums1[m--];
            }
            else nums1[idx--] = nums2[n--];
        }   
        while(n >= 0) {
            nums1[idx--] = nums2[n--];
        }
    }
}

*/
