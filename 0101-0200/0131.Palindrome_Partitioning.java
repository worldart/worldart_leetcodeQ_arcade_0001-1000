//22ms



class Solution {
    public List<List<String>> partition(String s) {
        // backtracking 
        // 1. define `ans` to hold `candidates`
        List<List<String>> ans = new ArrayList<>();
        // 2. define `candidates` to hold all potential candidates (palindromic substring)
        List<String> candidates = new ArrayList<>();
        // 3. start backtrack from index 0
        backtrack(s, ans, candidates, 0);
        // 4. return ans
        return ans;
    }
    
    private void backtrack(String s, List<List<String>> ans, List<String> candidates, int start) {
        // 1. check if the goal is fulfilled, 
        // i.e. reaching the end of string in this problem
        if (start == s.length()) {
            ans.add(new ArrayList<>(candidates));
            return;
        }
        // 2. find all potential candidates
        for (int i = start; i < s.length(); i++) {
            // we want to test all substrings, each substring is a potential candidate
            // e.g. "aab" -> "a", "a", "b", "ab", "aa", "b", "aab"
            String candidate = s.substring(start, i + 1);
            // 3. check if the current candidate is palindrome or not 
            // if not, then we cannot push to `candidates`
            if (!isPalindrome(candidate)) continue;
            // 4. if so, push it to candidates
            candidates.add(candidate);
            // 5. backtrack with index + 1
            backtrack(s, ans, candidates, i + 1);
            // 6. remove the current substring from `candidates`
            candidates.remove(candidates.size() - 1);
        }
    }
    
    // there are different ways to check if `s` is palindrome 
    // here's one of the ways
    private boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}




//0ms




class Solution {
    public List<List<String>> partition(String s) {
        return new java.util.AbstractList<>(){
            List<List<String>> res = null;
            private void build(){
                if(res!=null) return;
                res = new ArrayList<>();
                dfs(0, s, new ArrayList<>());
            }
            @Override
            public int size(){
                build();
                return res.size();
            }
            @Override
            public List<String> get(int i){
                build();
                return res.get(i);
            }
            private void dfs(int idx, String s, List<String> t){
                if(idx==s.length()){
                    res.add(new ArrayList<>(t));
                    return;
                }
                for(int i=idx+1;i<=s.length();i++){
                    if(isPalin(s, idx, i-1)){
                        t.add(s.substring(idx, i));
                        dfs(i, s, t);
                        t.remove(t.size()-1);
                    }
                }
            }
            private boolean isPalin(String s, int l, int r){
                while(l<=r){
                    if(s.charAt(l)!=s.charAt(r)) return false;
                    l++;
                    r--;
                }
                return true;
            }
        };
    }
}





//4ms






class Solution {
    int n;
    boolean[][] is_palindrome;
    String[][] substrings;

    List<List<String>> ans;

    void FindSubstrings(int ind, ArrayList<String> list) {
        if (ind == n) {
            ans.add(new ArrayList<String>(list));
            return;
        }

        for (int i = ind + 1; i <= n; i++) {
            if (!is_palindrome[ind][i]) continue;
            list.add(substrings[ind][i]);
            FindSubstrings(i, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        n = s.length();
        is_palindrome = new boolean[n + 1][n + 1];
        substrings = new String[n + 1][n + 1];
        for (int i = 0; i < n; i++) for (int j = i + 1; j <= n; j++) {
            substrings[i][j] = s.substring(i, j);
            is_palindrome[i][j] = IsPalindrome(substrings[i][j]);
        }

        ans = new ArrayList<List<String>>();
        FindSubstrings(0, new ArrayList<String>());
        return ans;
    }

    boolean IsPalindrome(String s) {
        int lower = 0;
        int higher = s.length() - 1;
        while (lower < higher) {
            if (s.charAt(lower) != s.charAt(higher)) return false;
            lower++;
            higher--;
        }
        return true;
    }
}

