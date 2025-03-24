#0ms

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        stack = [(root, float('-inf'), float('inf'))]

        while stack:
            node, min_val, max_val = stack.pop()

            if not node:
                continue
            
            if not (min_val < node.val < max_val):
                return False
            
            stack.append((node.right, node.val, max_val))
            stack.append((node.left, min_val, node.val))

        return True



'''
#3ms

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(root):
            if not root:
                return True, inf, -inf
            l, l_min, l_max = dfs(root.left)
            r, r_min, r_max = dfs(root.right)

            if l and r and l_max < root.val and r_min > root.val:
                return True, min(l_min, root.val), max(r_max, root.val)
            return False, inf, -inf
        return dfs(root)[0]
'''
