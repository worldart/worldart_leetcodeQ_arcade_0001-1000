#0ms



class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        word_set = set(wordDict)
        return self.wordBreakHelper(s, 0, word_set)
    
    def wordBreakHelper(self, s: str, start: int, word_set: set) -> List[str]:
        valid_substr = []
        
        if start == len(s):
            valid_substr.append("")
        for end in range(start + 1, len(s) + 1):
            prefix = s[start:end]
            if prefix in word_set:
                suffixes = self.wordBreakHelper(s, end, word_set)
                for suffix in suffixes:
                    valid_substr.append(prefix + ("" if suffix == "" else " ") + suffix)
        
        return valid_substr





#4ms




class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        memo = {}
        word_set = set(wordDict)
        return self.wordBreakHelper(s, 0, word_set, memo)
    
    def wordBreakHelper(self, s: str, start: int, word_set: set, memo: dict) -> List[str]:
        if start in memo:
            return memo[start]
        
        valid_substr = []
        
        if start == len(s):
            valid_substr.append("")
        for end in range(start + 1, len(s) + 1):
            prefix = s[start:end]
            if prefix in word_set:
                suffixes = self.wordBreakHelper(s, end, word_set, memo)
                for suffix in suffixes:
                    valid_substr.append(prefix + ("" if suffix == "" else " ") + suffix)
        
        memo[start] = valid_substr
        return valid_substr




#0ms




class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        """
        DFS over word combos

        Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
        Output: ["cats and dog","cat sand dog"]

        Space: O(2^len(s))
        Time: O(2^n)
        """
        wordDict = set(wordDict)
        res = [] #[]
        stack = [[[],s]]#(history, words to parse)
        # stack = []
        # res=["cat sand dog", "cats and dog"]
        while stack:
            hist, remaining = stack.pop()#hist=["cats","and"], curr="dog"       
            nextWord = ""#nextWord="dog"
            for i in range(len(remaining)):
                nextWord+=remaining[i]
                if nextWord in wordDict:
                    nextRemaining=remaining[i+1:]
                    if nextRemaining=="":
                        res.append(" ".join(hist+[nextWord]))
                    stack.append([hist+[nextWord], nextRemaining])
        return res
