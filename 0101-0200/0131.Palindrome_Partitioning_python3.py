#47ns




class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def is_palindrome(s):
            return s == s[::-1]
    
        def backtrack(s, ans, candidates, start):
            # 1. check if the goal is fulfilled, 
            # i.e. reaching the end of string in this problem
            if start == len(s):
                # if so, we push `candidates` to ans since we've processed all characters
                ans.append(list(candidates))
                return
            # 2. find all potential candidates
            for i in range(start, len(s)):
                # we want to test all substrings, each substring is a potential candidate
                # e.g. "aab" -> "a", "a", "b", "ab", "aa", "b", "aab"
                candidate = s[start:i+1]
                # 3. check if the current candidate is palindrome or not 
                # if not, then we cannot push to `candidates`
                if not is_palindrome(candidate):
                    continue
                # 4. if so, push it to candidates
                candidates.append(candidate)
                # 5. backtrack with index + 1
                backtrack(s, ans, candidates, i + 1)
                # 6. remove the current substring from `candidates`
                candidates.pop()

        # backtracking 
        # 1. define `ans` to hold `candidates`
        ans = []
        # 2. define `candidates` to hold all potential candidates (palindromic substring)
        candidates = []
        # 3. start backtrack from index 0
        backtrack(s, ans, candidates, 0)
        # 4. return ans
        return ans





#169ms





class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []
        part = []
        def isValid(i: int,j: int) -> bool:
            while i<j:
                if s[i]!=s[j]:
                    return False
                i+=1;j-=1
            return True


        def dfs(ind: int) -> None:
            print(ind,part)
            if ind == len(s):
                ans.append(part[:])
                return 
            for i in range(ind,len(s)):
                if isValid(ind,i):
                    part.append(s[ind:i+1])
                    dfs(i+1)
                    part.pop()
            return 

        dfs(0)
        return ans





#18ms






class Solution:
    @cache
    def partition(self, s: str) -> List[List[str]]:
        if len(s) == 0: return []
        if len(s) == 1: return ((s,),)
        res = []
        for i in range(1, len(s) + 1):
            a = s[:i]
            b = s[i:]
            if a == a[::-1]:
                if len(b) == 0:
                    res.append((a,))
                else:
                    for x in self.partition(b):
                        res.append((a,) + x)
        return res










#23ms









class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def gen(start, end):                
            ret = []
            if start == end:
                ret = [[]]

            # if s[start:end] in memory:
            #     return

            for i in range(start, end):
                prefix = s[start:i+1]
                if prefix == prefix[::-1]:
                    suffix = s[i+1: end]
                    if suffix not in memory:
                        gen(i+1, end)
                    
                    for suf in memory[suffix]:
                        ret.append([prefix] + suf)

            memory[s[start:end]] = ret



        if not s:
            return [[]]

        memory = collections.defaultdict(list)
        gen(0, len(s))
        return memory[s]

