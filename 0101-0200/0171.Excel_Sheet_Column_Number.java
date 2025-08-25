//1ms





class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int value = c - 'A' + 1;
            result = result * 26 + value;
        }
        return result;
    }
}






//2ms






class Solution {
    public int titleToNumber(String columnTitle) {
        int res=0;
        int pow=0;
        HashMap<Character,Integer> map=new HashMap<>();
        char ch='A';
        for(int i=1;i<=26;i++)
        {
            map.put(ch,i);
            ch++;
        }
        for(int i=columnTitle.length()-1;i>=0;i--)
        {
            char c=columnTitle.charAt(i);
            res+=(Math.pow(26,pow)*map.get(c));
            pow++;
        }
        return res;
    }
}
