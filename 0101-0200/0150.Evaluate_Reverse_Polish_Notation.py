

#11ms


class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        # Questions
        # Will there be invalid expressions?
        
        import operator
        
        stack = []
        operators = {
            '+': lambda x, y: x + y,
            '-': lambda x, y: x - y,
            '*': lambda x, y: x * y,
            '/': lambda x, y: int(operator.truediv(x, y))
        }
        
        for i, token in enumerate(tokens):
            if token not in operators:
                stack.append(int(token))
            elif token in operators:
                num1 = stack.pop()
                num2 = stack.pop()
                res = operators[token](num2, num1)
                stack.append(res)
        
        
        return stack[-1]
