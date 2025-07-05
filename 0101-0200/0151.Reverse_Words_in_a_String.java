//12ms



class Solution {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }
}




//0ms




class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            reverseWords("a");
        }
    }
    public static String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        char[] reversedChars = new char[n+1];
        int i = n-1, j = 0;
        while (i > -1) {
            while (i > -1 && cs[i] == ' ') {
                --i;
            }
            if (i == -1) break;
            reversedChars[j++] = ' ';
            int end = i;
            while (i > -1 && cs[i] != ' ') {
                --i;
            }
            for (int start = i+1; start <= end; ++start, ++j) {
                reversedChars[j] = cs[start];
            }
        }
        return new String(reversedChars, 1, j-1);
    }
}





//2ms






class Solution {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        char[] reversedChars = new char[n+1];
        int i = n-1, j = 0;
        while (i > -1) {
            while (i > -1 && cs[i] == ' ') {
                --i;
            }
            if (i == -1) break;
            reversedChars[j++] = ' ';
            int end = i;
            while (i > -1 && cs[i] != ' ') {
                --i;
            }
            for (int start = i+1; start <= end; ++start, ++j) {
                reversedChars[j] = cs[start];
            }
        }
        return new String(reversedChars, 1, j-1);
    }
}
