# 44.71%RT

class  Solution:
	def  groupAnagrams(self, strs: List[str]) -> List[List[str]]:
         ans = defaultdict(list)# {tuple: list}
         for word in strs: # T: O(N)
            count = [0] * 26 # a list for 26 distinct letters for each word in strs as a key
            for char in word:# T: O(M)
                count[ord(char) - ord('a')] += 1 # S: O(M)
            ans[tuple(count)].append(word) 
            # value in the dictionary is a list so we use append here
            # key must be immutable so we cast the mutable list as immutable tuple
         return list(ans.values())# cast the ans values as a list for output
