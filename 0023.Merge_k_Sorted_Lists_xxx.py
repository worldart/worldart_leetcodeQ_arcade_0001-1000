# Min Heap Approach
# O(Nlgk) = O(klgk + Nlgk)
#   where N is the number of total elements
#   and k is the number of sorted linked lists
# Idea:
#   We can leverage a min heap to extend the BF+ approach while
#   maintaing a ranking of the k minimum elements remaining in each list
#   without having to do unnecessary additional work recomparing nodes
#   we've already considered.
#   1) Build a min-heap of the first node of each of the k LinkedLists
#       O(klgk)
#   2) While there's a queue: (note all N elements added to it in total)
#       a) pop the minimum element from the heap O(lgk)
#       b) push its next node to the heap, if it exists O(lgk)
#       O(Nlgk)
# Best Runtime
# Runtime: 84 ms, faster than 90.17% of Python online submissions for Merge k Sorted Lists.
# Memory Usage: 17.5 MB, less than 40.91% of Python online submissions for Merge k Sorted Lists.
import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        # validate input
        if not lists:
            return None
        # shortcut, just return 1st linkedlist if only a single list
        if len(lists) == 1:
            return lists[0]

        # create a temporary head and a node pointer to track what
        #     elements we've added to the return list
        temp_head = ListNode(-1)
        node = temp_head

        # Create a min-heap tracking the smallest elements seen so far
        #   (up to k elements adde)
        queue = []
        for ll in lists:
            if ll:
                heapq.heappush(queue, (ll.val, ll))
        
        # while there's elts in the queue, 
        #   pop its minimum element and add it to the return llist
        #   if it has a next element, add that to the priority queue in its place
        while queue:
            value, next_node = heapq.heappop(queue)
            node.next = next_node
            if next_node.next:
                heapq.heappush(queue, (next_node.next.val, next_node.next))
            node = node.next
        
        return temp_head.next
