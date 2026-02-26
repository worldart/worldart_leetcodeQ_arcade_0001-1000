#3ms




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        temp = None
        temp2 = head

        while temp2 is not None:
            if temp2.val == val:
                if temp is None:
                    head = head.next
                    temp2 = head
                elif temp2.next is None:
                    temp.next = None
                    break
                else:
                    temp2 = temp2.next
                    temp.next = temp2
            else:
                temp = temp2
                temp2 = temp.next

        return head





#4ms





# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        if not head:
            return None
        while head and head.val == val:
            head = head.next           
        curr = head
        prev = None
        while curr:
            while curr and curr.val == val:
                prev.next = curr.next
                curr = curr.next
            if not curr:
                break
            prev = curr
            curr = curr.next
        return head






#0ms




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy = ListNode(next = head)
        prev = dummy 
        cur = dummy.next 
        while(cur):
            if cur.val == val: 
                prev.next = cur.next  
            else:
                prev = cur
            cur = cur.next 
            
        return dummy.next 
                 




#5ms





# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
       dummy=ListNode(0)
       dummy.next=head
       prev=dummy
       curr=head
       while curr:
        if curr.val==val:
            prev.next=curr.next
        else:
            prev=curr
        curr=curr.next
       return dummy.next

                


        










