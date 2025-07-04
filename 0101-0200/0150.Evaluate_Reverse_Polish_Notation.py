

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




$2ms


class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        operators = {"+", "-", "*", "/"}
        stack = []
        for token in tokens:
            if token not in operators:
                stack.append(int(token))
                # print(stack)
            else:
                num2 = stack.pop()
                num1 = stack.pop()
                if token == "+":
                    new_num = num1 + num2
                elif token == "-":
                    new_num = num1 - num2
                elif token == "*":
                    new_num = num1 * num2
                elif token == "/":
                    new_num = int(float(num1) / num2)
                stack.append(new_num)
                # print(stack)
        return stack[-1]





#1ms





class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        list1=['+','-','*','/']
        dict1={
            '+': lambda a,b: int(a)+int(b),
            '-': lambda a,b: int(a)-int(b),
            '*': lambda a,b: int(a)*int(b),
            '/': lambda a,b: int(a/b)
        }
        list2=[]
        for i in range(0,len(tokens)):
            if tokens[i] in list1:
                x=list2.pop()
                y=list2.pop()
                rst=dict1[tokens[i]](y,x)
                list2.append(rst)
            else:
                list2.append(int(tokens[i]))
        return list2[0]







#3ms





class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for token in tokens:
            if token in {"+", "-", "*", "/"}:
                b = stack.pop()
                a = stack.pop()

                if token == "+":
                    stack.append(a + b)
                elif token == "-":
                    stack.append(a - b)
                elif token == "*":
                    stack.append(a * b)
                elif token == "/":
                    stack.append(int(a / b))
            else:
                stack.append(int(token))
        
        return stack[0]
