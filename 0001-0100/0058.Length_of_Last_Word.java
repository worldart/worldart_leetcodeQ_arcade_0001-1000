//100%RT

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i)==' ' && count==0){
                continue;
            } else if (s.charAt(i)==' ' && count>0){
                break;
            } else {
                count++;
            }
        }
        return count;
    }
}
