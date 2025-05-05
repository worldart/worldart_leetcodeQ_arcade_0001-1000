#9ms

class Solution:
    def isPalindrome(self, s: str) -> bool:
        check = "".join([char.lower() for char in s if char.isalnum()])
    
        return check == check[::-1]





#4ms

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s =[char for char in s if char.isalnum()]
        return s[::-1] == s
        


#3ms


class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = ''.join([char for char in s if char.isalnum()]).lower()

        if (s==s[::-1]):
            return True
        else:
            return False

        
