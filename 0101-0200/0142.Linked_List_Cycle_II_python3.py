#53ms




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Floyd's Cycle Detection Algorithm (Tortoise and Hare)
        slow = head
        fast = head
        #fast will move two steps at a time and slow will move one step at a time
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast :
                #cycle is detected
                # return node
                entry = head
                while entry != slow:
                    entry = entry.next
                    slow = slow.next
                return entry
        else:
            #no cycle detected
            return None





#51ms




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        visited = set()
        while head:
            if head in visited:
                return head  
            visited.add(head)
            head = head.next
        return None   




#49ms






# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow=head
        fast=head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
            if slow==fast:
                slow=head
                while slow!=fast:
                    slow=slow.next
                    fast=fast.next
                return slow
        return 
