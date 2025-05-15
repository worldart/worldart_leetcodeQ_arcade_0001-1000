//13ms


class Solution {
public int minCut(String s) {
    char[] c = s.toCharArray();
    int n = c.length;
    int[] cut = new int[n];
    boolean[][] pal = new boolean[n][n];
    
    for(int i = 0; i < n; i++) {
        int min = i;
        for(int j = 0; j <= i; j++) {
            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true;  
                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
        }
        cut[i] = min;
    }
    return cut[n - 1];
}
}


//1ms


class Solution {
    public int minCut(String s) {

        char[] input = s.toCharArray();
        int len = s.length();
        int[] cut = new int[len];

        for (int i = 0; i < len; i++) cut[i] = i;
        for (int i = 1; i < len; i++) {
            if (input[i] == input[0])
                cut[i] = 0;
            else 
                break;
        }        
        
        for (int i = 1; i < len; i++) {
            int last = cut[i-1];
            int left = i-1;

            cut[i] = Math.min(cut[i], cut[i-1]+1);

            while (i < len-1 && input[i] == input[i+1]) {
                last = Math.min(last, cut[i++]);
                cut[i] = Math.min(cut[i], last+1);
            }

            int right = i+1;
            while (left > 0 && right < len && input[left] == input[right]) {
                cut[right] = Math.min(cut[right], cut[left-1]+1);
                left--;
                right++;
            }
            if (left == 0 && right < len && input[left] == input[right])
                cut[right] = 0;        
        }
        return cut[len-1];            
    }
}
