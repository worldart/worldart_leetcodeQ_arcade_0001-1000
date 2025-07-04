//0ms




class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;

        for (string c : tokens) {
            if (c == "+") {
                int second = st.top(); st.pop();
                int first = st.top(); st.pop();
                st.push(first + second);
            } else if (c == "-") {
                int second = st.top(); st.pop();
                int first = st.top(); st.pop();
                st.push(first - second);
            } else if (c == "*") {
                int second = st.top(); st.pop();
                int first = st.top(); st.pop();
                st.push(first * second);
            } else if (c == "/") {
                int second = st.top(); st.pop();
                int first = st.top(); st.pop();
                st.push(first / second);
            } else {
                st.push(stoi(c));
            }
        }

        return st.top();        
    }
};





//6ms







class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<string> evalStack;

        for (auto token: tokens) {
            if (isOperator(std::string_view(token))) {
                if (evalStack.size() < 2) {
                    throw std::runtime_error("Invalid RPN expresson!");
                }

                std::string value2 = evalStack.top();
                evalStack.pop();

                std::string value1 = evalStack.top();
                evalStack.pop();

                int value = evaluate(token, stoi(value1), stoi(value2));
                evalStack.push(std::to_string(value));
            } else {
                evalStack.push(token);
            }
        }

        return stoi(evalStack.top());        
    }

    int evaluate(std::string_view token, int value1, int value2) {
        if (token == "+") {
            return value1 + value2;
        } else if (token == "-") {
            return value1 - value2;
        } else if (token == "/") {
            return value1 / value2;
        } else if (token == "*") {
            return value1 * value2;
        } else {
            throw std::runtime_error("Invalid expression!");
        }
    }

    bool isOperator(std::string_view token) {
        return token == "+" || token == "-" || token == "/" || token == "*";
    }
};
