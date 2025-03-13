///0ms


class Solution {
    public List<Integer> grayCode(int n) {
    return new java.util.AbstractList<Integer>() {
            int size = 1 << n;
            public Integer get(int i) {
                return i ^ (i >> 1);
            }
            public int size() {
                return size;
            }
        };
    }
    public List<Integer> grayCode_v0(int n) {
    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
    return result;
}
    public List<Integer> grayCode_mycode(int n) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int twoNminus1 = 1;
        for (int i = 0; i < n; i++) twoNminus1 = twoNminus1 << 1;

        for (int i = 0; i < twoNminus1; i++) {
            int k = count1s(i);
            List<Integer> l = map.get(k);
            if (l == null) { l = new ArrayList<>(); map.put(k, l);}
            l.add(i);
        }
        System.out.println(map);
        return List.of(0,1,3,2,5,4,6,7);
    }

    
    int count1s(int i) {
        int c = 0;
        while (i > 0) {
            c += (i & 1) == 1 ? 1 : 0;
            i = i >> 1; 
        }
        return c;
    }
}
