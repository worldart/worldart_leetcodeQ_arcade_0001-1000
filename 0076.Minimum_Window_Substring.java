//1ms 100%RT

class Solution {
    public String minWindow(String s, String t) {
        char[] sourceChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        
        int start = 0;
        int end = 0;
        int startIndex = 0;
        int unmatchedCount = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int[] charFrequency = new int[128];
        
        // Count characters needed from target string
        for (char c : targetChars) {
            unmatchedCount++;
            charFrequency[c]++;
        }
        
        // Slide window through source string
        while (end < sourceChars.length) {
            // Expand window
            if(charFrequency[sourceChars[end]] > 0) {
                unmatchedCount--;
            }
            charFrequency[sourceChars[end]]--;
            end++;
            
            // Contract window when all characters are found
            while(unmatchedCount==0) {
                if(end - start < minWindowSize) {
                    startIndex = start;
                    minWindowSize = end - start;
                }
                if(charFrequency[sourceChars[start]] == 0) {
                    unmatchedCount++;
                }
                charFrequency[sourceChars[start]]++;
                start++;
            }
            
        }
        
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex +  minWindowSize);
    }
}
