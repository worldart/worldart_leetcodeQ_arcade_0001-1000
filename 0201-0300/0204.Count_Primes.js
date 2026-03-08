//





/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {
    let seen = new Uint8Array(n), ans = 0
    for (let num = 2; num < n; num++) {
        if (seen[num]) continue
        ans++
        for (let mult = num * num; mult < n; mult += num)
            seen[mult] = 1
    }
    return ans
};





//0ms




/**
 * @param {number} n
 * @return {number}
 */
const limit = 5 * 10**6;
const isPrime = new Uint8Array(limit + 1).fill(1);
const primes = [2, 3];

// On traite le crible en sautant 2 et 3
for (let i = 5; i * i <= limit; i += 6) {
    if (isPrime[i]) {
        for (let j = i * i; j <= limit; j += i) isPrime[j] = 0;
    }
    let next = i + 2;
    if (next * next <= limit && isPrime[next]) {
        for (let j = next * next; j <= limit; j += next) isPrime[j] = 0;
    }
}

for (let i = 5; i <= limit; i += 6) {
    if (isPrime[i]) primes.push(i);
    if (i + 2 <= limit && isPrime[i + 2]) primes.push(i + 2);
}

var countPrimes = function(n) {
    let low = 0, high = primes.length;
    while (low < high) {
        let mid = (low + high) >>> 1;
        if (primes[mid] < n) low = mid + 1;
        else high = mid;
    }
    return low;
};






//49ms




/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {
    // Corner cases: Primes strictly less than 3 are just 2 (if n > 2)
    if (n <= 2) return 0;
    
    // 1. Array Setup (Odd numbers only)
    // index i represents value: (2 * i + 1)
    // size is n / 2 because we skip all evens
    const halfN = n >>> 1; // ">>> 1" is bitwise division by 2
    const isComposite = new Uint8Array(halfN); 
    // Intentionally using 0 for Prime, 1 for Composite to skip .fill()

    const sqrtN = Math.sqrt(n);

    // 2. The Sieve (Iterate only up to sqrt(n))
    // We start i at 1 because i=0 represents number 1 (not prime, handled later)
    for (let i = 1; (2 * i + 1) <= sqrtN; i++) {
        // If current odd number is prime (0)
        if (isComposite[i] === 0) {
            const p = 2 * i + 1;
            
            // Start marking multiples at p * p
            // The index of p*p is: (p*p - 1) / 2
            // The step to the next odd multiple (p*p + 2p) is: p
            const startC = (p * p - 1) >>> 1;
            
            for (let j = startC; j < halfN; j += p) {
                isComposite[j] = 1;
            }
        }
    }

    // 3. Count Primes
    // Start count at 1 because we skipped the number '2' entirely
    let count = 1; 
    
    // Loop through our odds array
    // Start at i=1 because i=0 represents '1' (which is not prime)
    for (let i = 1; i < halfN; i++) {
        if (isComposite[i] === 0) count++;
    }

    return count;
};


















