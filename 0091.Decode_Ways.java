//1ms



class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 1 && s.charAt(0) != '0') return 1;
        if(s.charAt(0) == '0') return 0;

        int p1 = 0, p2 = 0;

        // for first element
        p2 = s.charAt(n - 1) == '0' ? 0: 1;

        // for second element
        if(s.charAt(n-2) == '0') p1 = 0;
        else if(isDoubleValid(s.charAt(n-2), s.charAt(n-1))) {
            if(s.charAt(n-1) == '0') p1 = 1;
            else p1 = 2;
        } else if(s.charAt(n-1) == '0') p1 = 0;
        else p1 = 1;

        for(int i = n - 3; i >= 0; i--) {
            int temp = p1;
            if(s.charAt(i) != '0') {
                if(isDoubleValid(s.charAt(i), s.charAt(i+1))) p1 += p2;
            } else p1 = 0;
            p2 = temp;
        }

        return p1;
    }

    

    private boolean isDoubleValid(char first, char second) {
        int num = (first - '0') * 10 + (second - '0');
        return num >= 10 && num <= 26;
    }
}
