//0ms





class Solution {
public:
    string reverseWords(string s) {
        stack<string> stack;
        stringstream ss(s);
        string token;

        // Split by space.
        while(getline(ss, token, ' '))
            if(!token.empty())
                stack.push(token);

        // Reconstruct the string.
        string res;
        while(!stack.empty()) {
            if(!res.empty())
                res+=" ";
            res+=stack.top();
            stack.pop();
        }
        return res;
    }
};



//0ms




class Solution {
public:
    string reverseWords(string s) {
        std::string output;
        int i = s.size() - 1;
        int j = 0;
        for(;i >= 0; i--){
            if(s[i] != ' '){
                j = i;
                while(i >= 0 && s[i] != ' '){
                    i--;
                }
                output.append(s.substr(i+1,j-i));
                output+=' ';
            }
        }
        output.resize(output.size()-1);
        return output;
    }
};





//4ms




#include<sstream>
class Solution {
public:
string reverseWords(string s) {
     vector<string> tokens;
    istringstream iss(s);
    string word;

    // Split words
    while (iss >> word) {
        tokens.push_back(word);
    }

    // Reverse word order
    reverse(tokens.begin(), tokens.end());

    // Join reversed words
    string reversedWords = "";
    for (int i = 0; i < tokens.size(); ++i) {
        reversedWords += tokens[i];
        if (i != tokens.size() - 1) reversedWords += " ";
    }

    return reversedWords;
}
};
