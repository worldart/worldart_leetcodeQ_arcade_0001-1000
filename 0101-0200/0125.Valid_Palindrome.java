//1ms


class Solution {
    public boolean isPalindrome(String s) {
        char[] chars=new char[s.length()];
        int i=0;
        for (char c: s.toCharArray())
        {
            if ((c>='a'&&c<='z')||(c>='0'&&c<='9'))
            {
                chars[i]=c;
                i++;
            }
            if (c>='A'&&c<='Z')
            {
                chars[i]=(char)(c+32);
                i++;
            }
        }
        for (int j=0; j<i; j++)
        {
            if (chars[j]!=chars[i-j-1])
                return false;
        }
        return true;
    }
}
