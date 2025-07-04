//5ms





class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        return stack.peek();        
    }
}





//0ms






class Solution {
    int i;

    public int evalRPN(String[] tokens) {
        i = tokens.length; // traversing from back side
        return eval(tokens);
    }

    public int eval(String[] tokens) {
        String currentString = tokens[--i];
        int k = 0, num = 0, sign = 1;
        char s = currentString.charAt(0);
        
        if (currentString.length() == 1) {
            switch (s) {
                case '+':
                    return eval(tokens) + eval(tokens);
                    //no break is used since its a return statement
                case '-':
                    return -eval(tokens) + eval(tokens);
                case '*':
                    return eval(tokens) * eval(tokens);
                case '/':
                    int second = eval(tokens);
                    int first = eval(tokens);
                    return first / second;
                default:
                    return s - '0'; // convert string to integer
            }
        }
        
        else {
            if (s == '-') {
                sign = -1;
                k++;
            }
            while (k < currentString.length()) {
                s = currentString.charAt(k++);
                num = num * 10 + s - '0';
            }
            return num * sign;
        }
    }
}
