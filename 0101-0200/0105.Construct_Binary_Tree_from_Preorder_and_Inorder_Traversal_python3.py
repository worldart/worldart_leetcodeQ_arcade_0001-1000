#1ms

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        imap ={val:idx for idx,val in enumerate(inorder)}
        stack=[]
        root = TreeNode(preorder[0])
        stack.append(root)
        for i in range(1,len(preorder)):
            node=TreeNode(preorder[i])
            prev=None
            while stack and imap[stack[-1].val]<imap[node.val]:
                prev = stack.pop()
            if prev:
                prev.right=node
            else:
                stack[-1].left=node
            stack.append(node)
        return root
