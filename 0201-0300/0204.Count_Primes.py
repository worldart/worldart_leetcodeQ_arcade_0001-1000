#4748ms



class Solution:
    def countPrimes(self, n: int) -> int:
        # If n <= 2, there are no primes less than n
        if n <= 2:
            return 0

        # Boolean array where is_prime[i] tells whether i is prime
        # Initially assume all numbers are prime
        is_prime = [True] * n

        # 0 and 1 are not prime
        is_prime[0] = False
        is_prime[1] = False

        # List to store discovered prime numbers
        primes = []

        # Iterate through all numbers from 2 to n-1
        for i in range(2, n):

            # If still marked prime, it is a prime number
            if is_prime[i]:
                primes.append(i)

            # Mark multiples of i using previously found primes
            # This prevents checking divisibility repeatedly
            for p in primes:

                # Stop if product goes out of range
                if i * p >= n:
                    break

                # Mark composite number
                is_prime[i * p] = False

        # Number of primes found
        return len(primes)




#0ms




class Solution:
    def countPrimes(self, n: int) -> int:
        if not n:
            return 0
        return cumulative[n - 1]

N = 5 * pow(10, 6)
is_prime = [1] * N
is_prime[0] = is_prime[1] = 0

for n in range(4, N, 2):
    is_prime[n] = 0

for num in range(3, floor(sqrt(N)) + 1, 2):
    if is_prime[num]:
        for multiple in range(num * num, N, num):
            is_prime[multiple] = 0
cumulative = list(accumulate(is_prime))





#73ms



class Solution:
    def countPrimes(self, n: int) -> int:
        if n <= 2:
            return 0
        
        # Initialize bytearray for odd numbers less than n.
        # The size is n // 2.
        # Index i represents the number (2 * i + 1).
        sieve = bytearray([1]) * (n // 2)
        
        # Index 0 represents number 1, which is not prime.
        sieve[0] = 0
        
        # We only need to iterate up to the square root of n.
        for i in range(3, int(n**0.5) + 1, 2):
            # Check if index corresponds to a prime number
            # (i - 1) // 2 converts number 'i' to its corresponding index
            if sieve[(i - 1) // 2]:
                # If i is prime, mark all its odd multiples as non-prime.
                # The first odd multiple to mark is i * i.
                # The step is 2 * i (since odd + odd = even, we skip even multiples).
                # In our index space (0, 1, 2...), a step of 2*i in numbers corresponds to a step of i in indices.
                start_index = (i * i - 1) // 2
                
                # We update the slice using standard slice assignment.
                # The length calculation ensures we generate a bytearray of the exact needed size.
                sieve[start_index::i] = bytearray((len(sieve) - 1 - start_index) // i + 1)
        
        # sum(sieve) counts the odd primes. We add 1 to include the even prime '2'.
        return sum(sieve) + 1
































