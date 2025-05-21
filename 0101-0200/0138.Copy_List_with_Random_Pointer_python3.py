#46ms



"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':    
        hash = {None:None}
        cur = head
        
        while cur:
            hash[cur] = Node(cur.val)
            cur = cur.next
            
        cur = head
        
        while cur:
            copy = hash[cur]
            copy.next = hash[cur.next]
            copy.random = hash[cur.random]
            cur = cur.next
            
        return hash[head]




#41ms





"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None: return None
        
        lookup = {head: Node(head.val)}
        node = head
        while node.next:
            lookup[node.next] = Node(node.next.val)
            lookup[node].next = lookup[node.next]
        
            node = node.next
            
        node = head
        while node:
            if node.random:
                lookup[node].random = lookup[node.random]
                
            node = node.next
        
        return lookup[head]






#46ms




"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        return copy.deepcopy(head)






#37ms





      """
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        if not head:
            return None
        curr = head

        while curr:
            copy = Node(curr.val, curr.next)
            curr.next = copy
            curr = copy.next
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        d = Node(0)
        curr = head
        copy = d

        while curr:
            copy.next = curr.next
            curr.next = curr.next.next

            curr = curr.next
            copy = copy.next
        return d.next










#43ms same as above 1&2







"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        # First pass: copy nodes and store mapping from original -> copy
        old_to_new = {}

        curr = head
        while curr:
            old_to_new[curr] = Node(curr.val)
            curr = curr.next

        # Second pass: assign next and random pointers
        curr = head
        while curr:
            copy = old_to_new[curr]
            copy.next = old_to_new.get(curr.next)
            copy.random = old_to_new.get(curr.random)
            curr = curr.next

        return old_to_new[head]
            
