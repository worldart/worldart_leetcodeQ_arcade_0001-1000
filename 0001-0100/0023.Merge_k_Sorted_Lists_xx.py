# Brute Force Approach
# O(NlgN) = O(aN + bNlgN + cN)
#   where N is the number of total elements
#   and k is the number of sorted linked lists
# Idea:
#   1) Traverse all linked lists, 
#       adding every element to an arraylist
#       O(N)
#   2) Sort the array list
#       O(NlgN)
#   3) Transform the array list into a linkedlist
#       O(N)
# Best Runtime
# Runtime: 68 ms, faster than 99.85% of Python online submissions for Merge k Sorted Lists.
# Memory Usage: 17.6 MB, less than 37.88% of Python online submissions for Merge k Sorted Lists.
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

        # Create an empty array and fill it with all the elements
        #     from the LinkedLists
        array = []
        for ll in lists:
            node = ll
            while node:
                array.append(node)
                node = node.next
        # Verify elements were actually added to the array (LL could have all been empty)
        if not array:
            return None                

        # Sort the array
        array.sort(key=lambda node: node.val)
    
        # Create a new linked list from the array
        head = array[0]
        for i in xrange(1, len(array)):
            prev = array[i-1]
            node = array[i]
            prev.next = node
        return head
