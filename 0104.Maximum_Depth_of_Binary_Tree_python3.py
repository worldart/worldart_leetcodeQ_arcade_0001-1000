#0ms

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        stk=[]
        if root:
            stk.append((1,root))
        depth=0
        while stk:
            curdepth,node=stk.pop()
            depth=max(depth,curdepth)
            if node.left:
                stk.append((curdepth+1,node.left))
            if node.right:
                stk.append((curdepth+1,node.right))
        return depth
