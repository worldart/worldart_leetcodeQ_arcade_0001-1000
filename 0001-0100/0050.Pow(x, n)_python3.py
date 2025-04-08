#100%RT

class Solution:
    def power(self, x: float, n: int) -> float:
        if n == 0:
            return 1  # Base case: x^0 = 1
        
        if n % 2 == 0:
            half = self.power(x, n // 2)
            return half * half  # If n is even
        
        return x * self.power(x, n - 1)  # If n is odd

    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x  # Handle negative powers by inverting x
            n = -n     # Work with positive n
        
        return self.power(x, n)
