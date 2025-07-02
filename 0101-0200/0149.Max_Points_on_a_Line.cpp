//37ms





class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        int maxi = 0;
        // x -> x[0],x[1]  (x1,y1)
        for (auto& x : points) {
            map<double, int> slopes;
            // y -> y[0],y[1]  (x2,y2)
            for (auto& y : points) {
                if (x == y) continue;
                double slope = numeric_limits<double>::infinity();
                // if (x2 - x1 != 0)
                if (y[0] - x[0] != 0) {
                    // slope = (y2 - y1) / (x2 - x1)
                    slope = (double)(y[1] - x[1]) / (y[0] - x[0]);
                }
                ++slopes[slope];
                maxi = max(maxi, slopes[slope]);
            }
        }
        return maxi + 1;
    }
};






//6ms






class Solution {
public:
    int gcd(int a, int b) {
        if (b==0)
            return a;
        return gcd(b, a%b);
    }

    int maxPoints(vector<vector<int>>& points) {
        // map<pair<pair<int, int>, int>, int> lines;
        vector<pair<int, int>> slopes;
        int a, b, cnt, _gcd, n=points.size(), max_points=1;

        for(int i=0;i<n;i++) {
            slopes.clear();

            for(int j=i+1;j<n;j++){
                a = points[j][1] - points[i][1];
                b = points[j][0] - points[i][0];
                _gcd = gcd(a, b);
                a /= _gcd;
                b /= _gcd;
                
                slopes.push_back({a, b});
            }
            sort(slopes.begin(), slopes.end());

            cnt = 0;
            for(int x=0;x<slopes.size();x++) {
                ++cnt;
                if(x==slopes.size()-1 || slopes[x]!=slopes[x+1]) {
                    max_points = max(max_points, cnt+1);
                    cnt = 0;
                }
            }
        }


        return max_points;
    }
};

