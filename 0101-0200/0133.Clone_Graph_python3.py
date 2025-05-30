#44ms



"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node: return node
        
        q, clones = deque([node]), {node.val: Node(node.val, [])}
        while q:
            cur = q.popleft() 
            cur_clone = clones[cur.val]            

            for ngbr in cur.neighbors:
                if ngbr.val not in clones:
                    clones[ngbr.val] = Node(ngbr.val, [])
                    q.append(ngbr)
                    
                cur_clone.neighbors.append(clones[ngbr.val])
                
        return clones[node.val]




#38ms





from typing import Optional

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node: return node
        mp = {}

        dfsStack = [node]
        mp[node] = Node(node.val)

        while dfsStack:
            u = dfsStack.pop()
            
            for v in u.neighbors:
                if v not in mp: 
                    mp[v] = Node(v.val)
                    dfsStack.append(v)
                mp[u].neighbors.append(mp[v])
        
        return mp[node]







#38ms






"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        stack = []
        res = { node: Node(node.val) }
        stack.append(node)
        while stack:
            cur = stack.pop()
            for neighbor in cur.neighbors:
                if not neighbor in res:                    
                    res[neighbor] = Node(neighbor.val)
                    stack.append(neighbor)
                res[cur].neighbors.append(res[neighbor])
                
        return res[node]




#38ms






"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        #return copy.deepcopy(node)
        
        def dfs(node,dic):
            if node.val in dic:
                return dic[node.val]
            newNode = Node(node.val)
            dic[node.val] = newNode
            for neigh in node.neighbors:
                newNode.neighbors.append(dfs(neigh,dic))
            return newNode
        return dfs(node,{})
