//0ms

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return[]
        res=[];q=[root]
        while q:
            s=len(q);t=[]
            for i in range(s):
                x=q.pop(0)
                t.append(x.val)
                if(x.left):q.append(x.left)
                if(x.right):q.append(x.right)
            res.append(t)
        return res
