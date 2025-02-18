//51ms 99.95%RT 20250218

class Solution {
public:
    long long maxWeight(vector<int>& p) {
        sort(p.begin(), p.end()); // \U0001f522 Sort the pizzas in ascending order \U0001f355
        int n = p.size();
        int m = n / 4; // \U0001f4c6 Total number of days (each day we eat 4 pizzas)
        int odd = (m + 1) / 2; // \U0001f535 Number of odd days
        int even = m - odd; // \U0001f7e2 Number of even days
        
        long long sum = 0;
        int l = n - 1; // \U0001f519 l points to the last element
        
        // \U0001f535 On odd days, we gain the weight of the heaviest pizza in the set of 4
        for (int i = 0; i < odd; i++) {
            sum += p[l]; // \U0001f355 Pick the largest pizza
            l--; // ⬅ Move left
        }
        
        // \U0001f7e2 On even days, we gain the weight of the second heaviest pizza in the set of 4
        for (int i = 0; i < even; i++) {
            l--; // ⏩ Skip third largest pizza
            sum += p[l]; // \U0001f355 Gain the weight of the second largest pizza
            l--; // ⬅ Move left again
        }
        
        return sum; // \U0001f522 Return maximum weight gained \U0001f3af
    }
};
