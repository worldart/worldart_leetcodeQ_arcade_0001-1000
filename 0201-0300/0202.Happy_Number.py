#0ms






class Solution:
    def isHappy(self, n: int) -> bool:
        if(n==1 or n==7):
            return True
        elif(n<10):
            return False
        else:
            sum =0
            while(n>0):
                temp = n%10
                sum += temp*temp
                n= n//10
            return self.isHappy(sum) 







#3ms






import math 
class Solution:
    def isHappy(self, n: int) -> bool:
        return self._helper(n, set())

    def _helper(self, n: int, seen: set):
        # Base case, if we have a 1 we know we are done
        if n == 1:
            return True
        
        #Check our set to see if we have seen number before (loop)
        if n in seen:
            return False 

        #Otherwise, calculate new number 
        #Need digits 
        s = str(n)
        new_num = 0
        for num in s:
            new_num += math.pow(int(num), 2)

        #Add new number to set 
        seen.add(n)
        return self._helper(int(new_num), seen)






#0ms






class Solution:
    def square(self,n): 
        sum = 0
        while n > 0:
            digit = n % 10
            total = digit ** 2
            sum += total
            n = n//10
        return sum

    def isHappy(self, n: int) -> bool:
        squaree = n
        seen = set()
        while squaree != 1 and squaree not in seen:
            seen.add(squaree)
            squaree = self.square(squaree)

        if squaree == 1: 
            return True
        else: 
            return False






#4ms






class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n != 1:
            if n in seen:
                return False
            seen.add(n)
            n = sum(int(digit) ** 2 for digit in str(n))
        return True







        
