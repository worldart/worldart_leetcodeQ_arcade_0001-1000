class Solution(object):
    def myAtoi(self, s):
        r, clamp = re.findall(r'^(\s+)?([-+]?\d+)', s), 2**31
        return min(clamp-1, max(-clamp, int(r[0][1]))) if r else 0
