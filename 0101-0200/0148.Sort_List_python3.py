#178ms





# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        
        # Find the middle of the linked list 
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        mid = slow.next
        slow.next = None
        
        # Sort both halves
        left = self.sortList(head)
        right = self.sortList(mid)
        
        return self.merge(left, right)
    
    def merge(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode(0)
        tail = dummy
        
        while l1 and l2:
            if l1.val < l2.val:
                tail.next = l1
                l1 = l1.next
            else:
                tail.next = l2
                l2 = l2.next
            tail = tail.next
        
        tail.next = l1 if l1 else l2
        return dummy.next





#12ms








# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        temp = []
        cur = head
        while cur:
            temp.append(cur.val)
            cur = cur.next
        temp.sort()
        cur = head
        for val in temp:
            cur.val = val
            cur = cur.next
        return head








#23ms







# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        arr = []
        temp = head
        while(temp):
            arr.append(temp.val)
            temp = temp.next
        
        arr.sort()
        temp = head
        index = 0
        while(temp):
            temp.val = arr[index]
            index+=1
            temp = temp.next
        return head
