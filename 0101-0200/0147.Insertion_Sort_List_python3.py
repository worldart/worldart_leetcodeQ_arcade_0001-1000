#560ms



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        sorted_list = ListNode(0)
        current = head
        while current != None:
            prev = sorted_list
            next_node = current.next
            while prev.next != None and prev.next.val < current.val:
                prev = prev.next
            current.next = prev.next
            prev.next = current
            current = next_node
        return sorted_list.next





#11ms





# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None

        sorted_deque = deque()
        node = head
        while node:
            # detach node.next so we don't create a cycle
            nxt = node.next
            node.next = None
            self._insert_node(node, sorted_deque)
            node = nxt

        # re-link the deque into a list
        for i in range(1, len(sorted_deque)):
            sorted_deque[i-1].next = sorted_deque[i]
        return sorted_deque[0]

    def _insert_node(self, node: ListNode, dq: deque):
        # binary search on dq to find first position where dq[pos].val > node.val
        l, r = 0, len(dq)
        while l < r:
            mid = (l + r) // 2
            if node.val < dq[mid].val:
                r = mid
            else:
                l = mid + 1
        dq.insert(l, node)






#25ms






# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        dummy = current = ListNode(0)
        while head:
            while current.next and current.next.val < head.val:
                current = current.next
            
            current.next, head.next, head = head, current.next, head.next 

            if head and current.val > head.val:
                current = dummy
        
        return dummy.next
