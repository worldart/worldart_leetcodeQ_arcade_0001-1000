//3ms





class Solution {
public:
    
    string largestNumber(vector<int>& nums) {
        vector<string> a;
        for (int i : nums) {
            a.push_back(to_string(i));
        }

        sort(a.begin(), a.end(), [](const string a, const string b) {
            return a + b > b + a;
        });
        string s;
        for (string x : a) {
            s += x;
        }

        while(s.length() > 1 and s[0] == '0') {
            s.erase(0, 1);
        }
        return s;
    }
};





//7ms





class Solution {
public:
    static bool compare(string a, string b) {
        return a + b > b + a;
    }

    string largestNumber(vector<int>& nums) {
        vector<string> strNums;
        for (int num : nums) {
            strNums.push_back(to_string(num));
        }

        sort(strNums.begin(), strNums.end(), compare);

        if (strNums[0] == "0") return "0";

        string result;
        for (string& s : strNums) {
            result += s;
        }

        return result;
    }
};
