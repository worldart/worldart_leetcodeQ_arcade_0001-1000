#0ms

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        return [int(num) for num in str(int("".join(map(str, digits)))+1)]
