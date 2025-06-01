#0ms



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: TreeNode) -> list[int]:
        result = []
        
        def dfs(node):
            if not node:
                return
            result.append(node.val)  # Visit root
            dfs(node.left)           # Traverse left subtree
            dfs(node.right)          # Traverse right subtree
        
        dfs(root)
        return result




#same



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        re=[]
        def traverse(node):
            if node:
                re.append(node.val)
                traverse(node.left)
                traverse(node.right)
        traverse(root)
        return re


    
        
