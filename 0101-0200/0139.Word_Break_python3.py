#3ms



class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        def construct(current,wordDict, memo={}):
            if current in memo:
                return memo[current]

            if not current:
                return True

            for word in wordDict:
                if current.startswith(word):
                    new_current = current[len(word):]
                    if construct(new_current,wordDict,memo):
                        memo[current] = True
                        return True

            memo[current] = False
            return False

        return construct(s,wordDict)





#1ms




class Solution:
    def wordBreak(self, s: str, wd: List[str]) -> bool:
        n=len(s)
        dic=defaultdict(lambda: None)
        def sol(ind):
            # if()
            if(dic[ind] is not None):
                return dic[ind]
            if(ind>=n):
                dic[ind]=True
                return True
            
            for w in wd:
                x=len(w)
                if(n-ind>=x and s[ind:ind+x]==w):
                    if(sol(ind+x)):
                        dic[ind]=True
                        return True
            dic[ind]=False
            return False
        return sol(0)




#0ms




class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        word_set = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True
        max_len = max(map(len, word_set)) if wordDict else 0

        for i in range(1, n + 1):
            for j in range(i - 1, max(i - max_len - 1, -1), -1):
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break

        return dp[n]
