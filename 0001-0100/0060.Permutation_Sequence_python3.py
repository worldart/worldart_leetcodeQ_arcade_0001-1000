#100%RT

class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        result = []
        combo = []
        fac = 1
        st = set()  # To track used numbers

        # Step 1: Initialize the combo array and compute factorial of n
        for i in range(1, n + 1):
            combo.append(i)
            fac *= i
        
        # Step 2: Recursive function to build the permutation
        def recursion(N, K):
            nonlocal result, n, st
            
            if n == 0:  # Base case: no numbers left to choose
                return
            
            fac = N // n  # Get factorial of (n-1)
            idx = K // fac  # Determine which number to choose
            
            # Find the idx-th unused number in the combo
            count = 0
            for num in combo:
                if num not in st:
                    if count == idx:
                        result.append(num)  # Add the number to the result
                        st.add(num)  # Mark this number as used
                        break
                    count += 1
            
            # Update K and N for the next recursion
            n -= 1
            recursion(fac, K % fac)  # Recurse with updated values
        
        recursion(fac, k - 1)
        
        # Convert the result list to a string
        return ''.join(map(str, result))
