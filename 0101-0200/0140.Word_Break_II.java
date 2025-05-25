//7ms




class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        return wordBreakHelper(s, 0, hs);
    }

    private List<String> wordBreakHelper(String s, int start, HashSet<String> dict) {
        List<String> validSubstr = new ArrayList<>();

        if (start == s.length())
            validSubstr.add("");
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (dict.contains(prefix)) {
                List<String> suffixes = wordBreakHelper(s, end, dict);
                for (String suffix : suffixes) {
                    validSubstr.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
                }
            }
        }
        return validSubstr;
    }
}




//1ms




class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // for O(1) lookups
        List<String> res = new ArrayList<>();
        backtrack(s, wordSet, new StringBuilder(), res, 0);
        return res;
    }

    private void backtrack(String s, Set<String> wordSet, StringBuilder currentSentence, List<String> res, int startIndex) {
        if (startIndex == s.length()) {
            res.add(currentSentence.toString().trim());
            return;
        }

        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            String word = s.substring(startIndex, endIndex);
            if (wordSet.contains(word)) {
                int currentLength = currentSentence.length();
                currentSentence.append(word).append(" ");
                backtrack(s, wordSet, currentSentence, res, endIndex);
                currentSentence.setLength(currentLength);
            }
        }
    }
}





//0ms






class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>(wordDict);

        dfs(s, set, 0, sb, res);

        return res;

    }

    private void dfs(String s, Set<String> set, int index, StringBuilder sb, List<String> res) {
        if(index >= s.length()) {
            res.add(sb.toString());
            return;
        }

        for(int i = index; i <= s.length(); i++) {
            String potential = s.substring(index, i);
            if(set.contains(potential)) {
                int beforeAdding = sb.length();
                if(beforeAdding != 0) {
                    sb.append(" ");
                }
                sb.append(potential);
                dfs(s, set, i, sb, res);
                sb.setLength(beforeAdding);
            }
        }
    }
}
