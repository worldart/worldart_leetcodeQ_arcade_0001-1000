//5ms





class Solution {
    public String largestNumber(int[] nums) {
        String[] a = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(a, (x, y) -> (y + x).compareTo(x + y));
        StringBuilder s = new StringBuilder();
        for (String x : a) {
            s.append(x);
        }
        while (s.length() > 1 && s.charAt(0) == '0') {
            s.deleteCharAt(0);
        }
        return s.toString();
    }
}




//1ms






class Solution {
    public String largestNumber(int[] nums) {
        // Sort using custom comparator on ints directly
        quickSort(nums, 0, nums.length - 1);

        // If the largest number is 0, return "0"
        if (nums[0] == 0) return "0";

        // Build result (still need strings at the end to concatenate output)
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot) > 0) { 
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Custom comparator without strings
    private int compare(int x, int y) {
        long xy = concat(x, y);
        long yx = concat(y, x);
        return Long.compare(xy, yx);
    }

    // Concatenate two numbers mathematically
    private long concat(int a, int b) {
        int pow = 10;
        while (pow <= b) {
            pow *= 10;
        }
        return (long) a * pow + b;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
