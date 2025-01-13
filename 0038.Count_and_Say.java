//47.20% RT

public class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            int j = 0;
            while (j < ans.length()) {
                int cnt = 0;
                char ch = ans.charAt(j);
                while (j < ans.length() && ans.charAt(j) == ch) {
                    cnt++;
                    j++;
                }
                temp.append(cnt).append(ch);
            }
            ans = temp.toString();
        }
        return ans;
    }
}
