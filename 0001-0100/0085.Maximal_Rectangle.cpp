//2ms


class Solution {
public:
    int maxHistrect(vector<int>& arr) {
        stack<int> st;
        int maxArea = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] > arr[i]) {
                int el = arr[st.top()];
                st.pop();
                int nse = i;
                int pse = (st.empty()) ? -1 : st.top();
                maxArea = max(maxArea, el * (nse - pse - 1));
            }
            st.push(i);
        }

        while (!st.empty()) {
            int nse = n;
            int el = arr[st.top()];
            st.pop();
            int pse = (!st.empty()) ? st.top() : -1;
            maxArea = max(maxArea, el * (nse - pse - 1));
        }

        return maxArea;
    }

    int maximalRectangle(vector<vector<char>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> prefixSum(n, vector<int>(m,0));

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {

                if(matrix[i][j] =='1'){
                    sum+=1;
                }
                else if(matrix[i][j] == '0'){
                    sum = 0;
                }
                prefixSum[i][j] = sum;
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = max(maxArea, maxHistrect(prefixSum[i]));
        }

        return maxArea;
    }
};
