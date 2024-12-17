class Solution(object):
    def isValid(self, s):
        stack = []  # Initialize an empty list to represent the stack

        if len(s) % 2 != 0:
            return False
        else:
            left = ['(', '[', '{']
            right = [')', ']', '}']

            for char in s:
                if char in left:
                    stack.append(char)
                elif char in right:
                    if not stack:  # Check if the stack is empty before 
                        return False
                    top = stack.pop()
                    if char == ')':
                        if top != '(':
                            return False
                    elif char == '}':
                        if top != '{':
                            return False
                    elif char == ']':
                            if top != '[':
                                return False
            return not stack  # Return True if the stack is empty, False otherwise
