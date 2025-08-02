//16ms




class Solution {
public:
    int maximumGap(vector<int>& nums) {
        if (nums.size() < 2) return 0;

        int minVal = *min_element(nums.begin(), nums.end());
        int maxVal = *max_element(nums.begin(), nums.end());
        int n = nums.size();

        int bucketSize = max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        vector<int> bucketMin(bucketCount, INT_MAX);
        vector<int> bucketMax(bucketCount, INT_MIN);
        vector<bool> used(bucketCount, false);

        for (int num : nums) {
            int idx = (num - minVal) / bucketSize;
            bucketMin[idx] = min(bucketMin[idx], num);
            bucketMax[idx] = max(bucketMax[idx], num);
            used[idx] = true;
        }

        int maxGap = 0, prevMax = minVal;
        for (int i = 0; i < bucketCount; ++i) {
            if (!used[i]) continue;
            maxGap = max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }
};





//10ms







struct Bucket {
  int mn;
  int mx;
};

class Solution {
 public:
  int maximumGap(vector<int>& nums) {
    if (nums.size() < 2)
      return 0;

    const int mn = ranges::min(nums);
    const int mx = ranges::max(nums);
    if (mn == mx)
      return 0;

    const int gap = ceil((mx - mn) / (double)(nums.size() - 1));
    const int bucketSize = (mx - mn) / gap + 1;
    vector<Bucket> buckets(bucketSize, {INT_MAX, INT_MIN});

    for (const int num : nums) {
      const int i = (num - mn) / gap;
      buckets[i].mn = min(buckets[i].mn, num);
      buckets[i].mx = max(buckets[i].mx, num);
    }

    int ans = 0;
    int prevMax = mn;

    for (const Bucket& bucket : buckets) {
      if (bucket.mn == INT_MAX)
        continue;  // empty bucket
      ans = max(ans, bucket.mn - prevMax);
      prevMax = bucket.mx;
    }

    return ans;
  }
};



