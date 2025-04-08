import heapq
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        dummyNode = ListNode()
        current  =  dummyNode 
        min_heap = []
        for i,head in enumerate(lists): 
            if head:
                heapq.heappush(min_heap,(head.val,i,head))
        while len(min_heap)>0: 
            _,index,node = heapq.heappop(min_heap)
            current.next = node
            current = current.next
            if node.next: 
                heapq.heappush(min_heap,(node.next.val,index,node.next))        
        return dummyNode.next
                
        
