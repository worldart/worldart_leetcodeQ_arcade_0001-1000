#0ms


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        # Initialize the queue with the root node and its depth
        queue = [(root, 1)]
        
        while queue:
            # Dequeue the first node and its depth
            node, depth = queue.pop(0)
            
            # If the node is a leaf, return its depth
            if not node.left and not node.right:
                return depth
            
            # Enqueue the left and right children if they exist
            if node.left:
                queue.append((node.left, depth + 1))
            if node.right:
                queue.append((node.right, depth + 1))
