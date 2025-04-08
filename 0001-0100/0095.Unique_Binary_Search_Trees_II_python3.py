#0ms

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        if n == 0:
            return []

        @lru_cache(None)  # Memoization to avoid recomputation
        def generate(start, end):
            if start > end:
                return [None]  # Empty tree
            
            all_trees = []
            for i in range(start, end + 1):  # Choose `i` as root
                left_trees = generate(start, i - 1)
                right_trees = generate(i + 1, end)
                
                # Combine left and right trees
                for left in left_trees:
                    for right in right_trees:
                        root = TreeNode(i)
                        root.left = left
                        root.right = right
                        all_trees.append(root)
            
            return all_trees
        
        return generate(1, n)
