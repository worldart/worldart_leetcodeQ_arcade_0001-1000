//39ms



class Solution {
public:
    int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        bool isprime[n];

        memset(isprime, true, n);

        int result = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (isprime[i]) {
                int d = i * 2;
                for (int j = i * i; j < n; j += d) {
                    if (isprime[j]) {
                        isprime[j] = false;
                        result--;
                    }
                }
            }
        }
        return result;
    }
};





//0ms





int MAX = 6e6;

vector<bool> GenerateSieve() {
    vector<bool> isprime(MAX, true);

    isprime[0] = false;
    isprime[1] = false;

    for (int i = 2; i * i < MAX; i++){
        if (isprime[i]) {
            for(int j = i * i; j < MAX; j += i) {
                if (isprime[j]) {
                    isprime[j] = false;
                }
            }
        }
    }

    return isprime;
}

vector<bool> isprime = move(GenerateSieve());

vector<int> GenerateAns() {
    vector<int> ans(MAX, 0);

    ans[0] = 0;
    ans[1] = 0;

    for (int i = 2; i < MAX; i++)
        ans[i] = ans[i - 1] + isprime[i - 1];

    return ans;
}

vector<int> ans = move(GenerateAns());

class Solution {
public:
    int countPrimes(int n) {
        return ans[n];
    }
};





//198ms







class Solution {
public:
    int countPrimes(int n) 
    {
        vector<bool> primes(n+1,true);
        primes[0]=false;
        primes[1]=false;
        for(long long i=2;i<=n;i++) if(primes[i]) for(long long j=i*i;j<=n;j+=i) primes[j]=false;
        int ans=0;
        for(int i=2;i<n;i++) if(primes[i]) ans++;
        return ans;
    }
};







//18ms





class Solution {
    const static int N = 5000005;
    static bool done;
    static char isPrime[N];   // char is faster than vector<bool>
    static int primeCount[N]; // prefix sum of primes

    void sieve() {
        if (done) return;
        for (int i = 0; i < N; i++) isPrime[i] = 1;
        isPrime[0] = isPrime[1] = 0;

        for (int i = 2; i*i < N; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j < N; j += i)
                    isPrime[j] = 0;
            }
        }

        primeCount[0] = 0;
        for (int i = 1; i < N; i++)
            primeCount[i] = primeCount[i-1] + isPrime[i];

        done = true;
    }

public:
    int countPrimes(int n) {
        sieve();
        if (n < 2) return 0;
        return primeCount[n-1]; // primes strictly less than n
    }
};

// static members
bool Solution::done = false;
char Solution::isPrime[Solution::N];
int Solution::primeCount[Solution::N];

















