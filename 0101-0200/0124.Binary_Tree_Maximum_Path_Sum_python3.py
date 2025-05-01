#17ms


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
1.# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        max_path = float("-inf")  # placeholder to be updated

        def get_max_gain(node):
            nonlocal max_path  # This tells that max_path is not a local variable

            if node is None:
                return 0

            # Recursively get the maximum gain from left and right subtrees
            gain_on_left = max(get_max_gain(node.left), 0)
            gain_on_right = max(get_max_gain(node.right), 0)

            # The price of the new path
            current_max_path = node.val + gain_on_left + gain_on_right

            # Update global max_path if needed
            max_path = max(max_path, current_max_path)

            # For recursion: return the max gain the parent can use
            return node.val + max(gain_on_left, gain_on_right)

        get_max_gain(root)  # Start the recursion
        return max_path


#17ms


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
1.# Definition for a binary tree node.
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxs = float('-inf')
        def dfs(node):
            if not node:
                return 0
            left = max(dfs(node.left), 0)
            right = max(dfs(node.right), 0)

            cur_sum = node.val + left + right
            self.maxs = max(self.maxs, cur_sum)
            return node.val + max(left, right)
        dfs(root)
        return self.maxs



#7ms

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        def get_max_path(root):

            if root is None:
                return [None, None]
            
            if root.left is None and root.right is None:
                return [root.val, root.val]
            
            if root.left is not None and root.right is not None:
                [left_max, left_including_max] = get_max_path(root.left)
                [right_max, right_including_max] = get_max_path(root.right)

                max_including_root = max(root.val, root.val + left_including_max, root.val + right_including_max)
                max_root = max(max_including_root, left_max, right_max, left_including_max + root.val + right_including_max)

                return [max_root, max_including_root]
            
            if root.left is not None and root.right is None:
                [left_max, left_including_max] = get_max_path(root.left)

                max_including_root = max(root.val, root.val + left_including_max)
                max_root = max(max_including_root, left_max, left_including_max + root.val)

                return [max_root, max_including_root]

            if root.right is not None and root.left is None:
                [right_max, right_including_max] = get_max_path(root.right)

                max_including_root = max(root.val, root.val + right_including_max)
                max_root = max(max_including_root, right_max, root.val + right_including_max)

                return [max_root, max_including_root]
        
        return get_max_path(root)[0]



#11ms


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        # to calculate the max path sum for a given node, we need to know the max path of the left and right subtrees first -> postorder L R C
        # WHAT IS MAX AT THAT NODE - node + left_max + right_max  (left to right, including node)
        # WHAT CONTINUES UP - think of turning at each node, towards the one with the more contribution, ignore if -ve

        self.maxSum = float("-inf")
        def postorder(node):
            if not node:
                return 0
            
            left_max = postorder(node.left)
            if left_max<0:
                left_max=0
            right_max = postorder(node.right)
            if right_max<0:
                right_max=0
            
            max_at_node = node.val+left_max+right_max
            self.maxSum = max(self.maxSum,max_at_node)

            return node.val+ max(left_max,right_max)
        
        postorder(root)
        return self.maxSum



#7ms


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def traverse(self, node):
        if node.left is None and node.right is None:
            self.max_path_sum = max(self.max_path_sum, node.val)
            return max(node.val, 0)
        left_sum = right_sum = 0
        if node.left:
            left_sum = self.traverse(node.left)
        if node.right:
            right_sum = self.traverse(node.right)
        # max sum path going through node
        self.max_path_sum = max(self.max_path_sum, left_sum + node.val + right_sum)
        return max(0, node.val + left_sum, node.val + right_sum)

    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.max_path_sum = float('-inf')
        self.traverse(root)
        return self.max_path_sum
  
        
