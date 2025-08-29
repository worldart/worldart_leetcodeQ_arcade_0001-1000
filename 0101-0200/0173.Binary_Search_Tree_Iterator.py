#





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.s = []
        self._push_left(root)

    def _push_left(self, node):
        while node:
            self.s.append(node)
            node = node.left
    
    def next(self) -> int:
        node = self.s.pop()
        if node.right:
            self._push_left(node.right)
        return node.val

    def hasNext(self) -> bool:
        return len(self.s) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()







#8ms






# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.pointer = root
        self.lst = []
        self.idx = 0

        def inorder(node): # to find what is the min
            if node is None:
                return
            inorder(node.left)
            self.lst.append(node.val)
            inorder(node.right)
        
        inorder(root)

    def next(self) -> int:
        ans = self.lst[self.idx]
        self.idx += 1
        return ans

    def hasNext(self) -> bool:
        return self.idx < len(self.lst)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
