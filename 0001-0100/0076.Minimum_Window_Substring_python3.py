#121ms



class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not t or not s:
            return ""
        
        
        need_dict = {}
        char_types = 0
        for c in t:
            if c not in need_dict:
                char_types+=1
                need_dict[c] = 1
            else:
                need_dict[c] += 1

        left = 0
        ans = (0,1e9,'')
        for i,si in enumerate(s):
            if si in need_dict:
                need_dict[si] -= 1
                if need_dict[si] == 0:
                    char_types -= 1

            while char_types==0:
                ans = (left,i,s[left:i+1]) if i+1-left < ans[1]+1-ans[0] else ans
                if left == i:
                    break

                sl = s[left]
                if sl in need_dict:
                    need_dict[sl] += 1
                    if need_dict[sl] == 1:
                        char_types += 1
                left = left + 1

        return ans[-1]




#39ms



class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        needstr = collections.defaultdict(int)
        for ch in t:
            needstr[ch] += 1
        needcnt = len(t)
        res = (0, float('inf'))
        start = 0
        for end, ch in enumerate(s):
            if needstr[ch] > 0:
                needcnt -= 1
            needstr[ch] -= 1
            if needcnt == 0:
                while True:
                    tmp = s[start]
                    if needstr[tmp] == 0:
                        break
                    needstr[tmp] += 1
                    start += 1
                if end - start < res[1] - res[0]:
                    res = (start, end)
                needstr[s[start]] += 1
                needcnt += 1
                start += 1
        return '' if res[1] > len(s) else s[res[0]:res[1]+1]
