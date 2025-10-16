//17ms







class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		if(s == null || s.length() < 10) {
			return Collections.emptyList();
		}
		int start = 0;
		int end = 10;
		Set<String> set = new HashSet<>();
		Set<String> result = new HashSet<>();
		StringBuilder builder = new StringBuilder(s);
		while(end <= s.length()) {            
			//String curr = s.substring(start,end);   
			//builder is faster, so using builder below
			String curr = builder.substring(start,end);   
			if(set.contains(curr)) {
				result.add(curr);
			}
			set.add(curr);
			start++;
			end++;
		}
		return new ArrayList<>(result);
	}
}







//17ms







class Solution {
    public List<String> findRepeatedDnaSequences(String s) {     
       int l=s.length();
        if (l < 10 ||l>10000) return new ArrayList<>();

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

       
       for (int i = 0; i+9 < l; i++)  {
            String substr = s.substring(i, i + 10);
            if (!seen.add(substr)) {  
                repeated.add(substr);
            }
            
        }

        
        return new ArrayList<>(repeated);
    }
}








//4ms







class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        char[] c = s.toCharArray();
        long b = 11;
        long m = (long)10E+12 + 7;
        long deg = 1;
        long h = 0;
        // h = 31^0 * c[0] +...+ 31^n * c[n]
        // h = h - c[0]
        // h = (31^1 * c[1] + ...+ 31^n * c[n]) / 31
        // h = 31^0 * c[1] +...+ 31^n-1 * c[n]
        // h = h + 31^n * c[n + 1]

        if(s.length() < 10 || s.length() > 10000)
          return new ArrayList<>();

        Set<Long> set = new HashSet<>(c.length / 10);
        Set<Long> resultSet = new HashSet<>(c.length / 10);
        List<String> result = new ArrayList<>(c.length / 10);

        int j = 0, i = 0;

        while (i < c.length - 9 && j < c.length) {

            while (j < i + 10 && j < c.length) { 
                h = (h + c[j]*deg);
                deg = deg * b;
                j ++;
            }
            deg = deg / b;

            if (set.contains(h) && resultSet.add(h)) {
                result.add(new String(c, i, 10));
            } else {
                set.add(h);
            }

            h = (h - c[i]);
            h = (h / b);
            i ++;
        }
        
        return result;
    }
}
