//1ms 99.83%RT 20250308

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        int max = heights[0];
        std::vector<std::pair<int, int>> tmp(n);
        tmp[0] = {max, 0};
        int i = 0;
        int l;
        for (int r = 1; r < n; ++r) {
            if (heights[r] > heights[r - 1]) {
                tmp[++i] = {heights[r], r};
                continue;
            }
            if (heights[r] < heights[r - 1]) {
                while (i >= 0 && heights[r] < tmp[i].first) {
                    l = tmp[i].second;
                    max = std::max(max, tmp[i].first * (r - tmp[i--].second));
                }
                tmp[++i] = {heights[r], l};
            }
        }
        for (; i >= 0; --i) {
            max = std::max(max, tmp[i].first * (n - tmp[i].second));
        }
        return max;
    }
};
