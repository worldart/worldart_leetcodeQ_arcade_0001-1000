//0ms


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    # Helper function to reverse a linked list
    def reverseLL(self, head):
        if not head or not head.next:
            return head
        last = self.reverseLL(head.next)
        head.next.next = head
        head.next = None
        return last

    def reverseBetween(self, head, left, right):
        if left == right or not head:
            return head
        
        # Dummy node to handle edge cases (e.g., reversing from head)
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy

        # Move to the node before 'left'
        for _ in range(1, left):
            prev = prev.next

        # Identify the start and end of the sublist
        start = prev.next
        end = start
        for _ in range(left, right):
            end = end.next

        # Save the rest of the list after 'right'
        rest = end.next
        end.next = None  # Isolate the sublist

        # Reverse the sublist
        reversed_sublist = self.reverseLL(start)

        # Reconnect the reversed sublist back to the main list
        prev.next = reversed_sublist
        start.next = rest

        return dummy.next
