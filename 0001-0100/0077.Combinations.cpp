//30ms 99.65%


class Solution {
public:

    int nCr(int n, int k) {
        k = min(k, n - k);
        int ans = 1;

        for (int i = 1; i <= k; i++) {
            ans *= n - k + i;
            ans /= i;
        }

        return ans;
    }

	vector<vector<int>> combine(int n, int k) {
		vector<vector<int>> result;
		int i = 0;
        result.reserve(nCr(n, k));
		vector<int> p(k);
		while (i >= 0) {
			p[i]++;
			if (p[i] > n) --i;
			else if (i == k - 1) result.push_back(p);
			else {
			    ++i;
			    p[i] = p[i - 1];
			}
		}
		return result;
	}
};
