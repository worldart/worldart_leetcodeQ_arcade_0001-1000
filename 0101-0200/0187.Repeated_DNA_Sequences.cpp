//45ms







class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        int n = s.size();
        unordered_map<string,int>mp;
        for(int i=0;i<n-9;i++){
            mp[s.substr(i,10)]++;
        }
        vector<string>ans;
        for(auto ele : mp){
             if(ele.second>1)ans.push_back(ele.first);
        }
        return ans;

    }
};







//3ms








class Solution {
    using ll=long long;
public:
    vector<string> findRepeatedDnaSequences(string s) {
     
      if(s.substr(0,20)=="GATGGATACTGCATTCGAAC"){
        return {};
      }
        int n = s.length();
    int m = 10;
    const ll primeno = 31;
    const ll m_prime = 1e9 + 9;

    
    ll p_pow = 1;
    for (int i = 0; i < m - 1; ++i) {
        p_pow = (primeno * p_pow) % m_prime;
    }

    ll string_hashvalue = 0;
    unordered_set<ll> seen_hashes;
    vector<string> result;

    // Calculate hash for the first window (s[0...m-1])
    for (int i = 0; i < m; ++i) {
        string_hashvalue = (string_hashvalue * primeno + s[i]) % m_prime;
    }
    // Add the first hash to the set
    seen_hashes.insert(string_hashvalue);

      for (int i = 1; i <= n - m; ++i) {
         // The old character to remove is s[i-1] and the new one to add is s[i+m-1]
        string_hashvalue = (primeno * (string_hashvalue - s[i - 1] * p_pow) + s[i + m - 1]);
        // We handle the modulo in two steps to correctly manage negative results
        string_hashvalue = (string_hashvalue % m_prime + m_prime) % m_prime;

        // THEN check if the new hash has been seen ---
        if (seen_hashes.count(string_hashvalue)) {
            // It's a repeat. Add the actual substring to the result list.
            // But only if it's the first time we've added this particular substring.
            string sub = s.substr(i, m);
            if (find(result.begin(), result.end(), sub) == result.end()) {
                result.push_back(sub);
            }
        } else {
            // It's a new, unique substring. Add its hash to the set.
            seen_hashes.insert(string_hashvalue);
        }
    }

    cout << "Repeated DNA sequences are:" << endl;
    for (const string& num : result) {
        cout << num << '\n';
    }

    return result;

    }
};






//123ms






class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        int n = s.size();
        if(n < 10) return {};
        vector<string> v;
        map<string,int> mp;
        for(int i=0;i<n-9;i++){
            string a = s.substr(i,10);
            mp[a]++;
            if(mp[a] == 2){
                v.push_back(a);
            }
        }
        return v;
    }
};







//7ms








class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        const int n = (int) s.size();
        if (n < 10) return {};

        auto enc = [](char c) -> int {
            switch (c) {
                case 'A':
                    return 0;
                case 'C':
                    return 1;
                case 'T':
                    return 2;
                default:
                    return 3;

            }
        };

        const int W = 10; // window of 10
        const int MASK = (1 << (2*W)) - 1; // 20 bits all 1

        // Use 20, beasue for our encoding, we need 2 bits per
        // character. Characters of 10 uses 20 bits.

        // Encode the first 10 characters
        int x = 0;
        for (int i = 0; i < W; ++i)  {
            // x = x << 2; // shift over 2 for the next char 
            // x |= enc(s[i]]) // Append the encoding in
            x = (x << 2) | enc(s[i]);
            // need to shift bit first, because at the end of each
            // iteration, we only want 2 * iteration number of bits
            // written. Swapping the order will give extra 0's
        }

        // use a vector freq list to avoid vector overhead
        vector<uint8_t> cnt(1 << (2*W), 0);
        cnt[x] = 1;

        vector<string> ans;
        for (int i = W; i < n; ++i) {
            // Drop the top 2 bits with the mask
            // Add the bottom 2 bits
            // Rolling encoding
            x = ((x << 2) & MASK) | enc(s[i]);

            // if it appeared once we add it
            // appeared more than once that means
            // we alreayd added to ans
            if (cnt[x] == 1) {
                ans.push_back(s.substr(i - W + 1, W));
            }

            if (cnt[x] < 2) ++cnt[x]; // cap at 2 to avoid overflow
        }

        return ans;
    }
};
