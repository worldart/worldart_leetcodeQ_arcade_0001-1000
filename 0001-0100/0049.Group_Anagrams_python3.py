#83.48RT

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = defaultdict(list)  # {tuple: list}

        for word in strs:  # T: O(m)
            sorted_word = ''.join(sorted(word))  # T: O(nlogn)
            ans[sorted_word].append(word)  # S: O(m)

        return list(ans.values())  # Return the grouped anagrams


