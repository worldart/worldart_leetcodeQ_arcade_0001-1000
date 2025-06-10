//




 /**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:

   ListNode* sortList(ListNode* head, ListNode* tail = nullptr)
  {
    if (head != tail) {
      // Use head node as the pivot node
      // Everything in the _smaller_ list will be less than _head_
      // and everything appearing after _head_ in the list is greater or equal
      ListNode* smaller;
      ListNode** smaller_next = &smaller;
      for (ListNode** prev = &head->next; *prev != tail; ) {
        if (head->val > (**prev).val) {
          *smaller_next = *prev;
          smaller_next = &((**smaller_next).next);

          // Remove smaller node from original list
          *prev = (**prev).next;
        } else {
          // Correct position, skip over
          prev = &((**prev).next);
        }
      }

      // Connect the end of smaller list to the head (which is the partition node)
      // We now have. [smaller list...] -> head -> [larger list]
      *smaller_next = head;

      // Continue to sort everything after head
      head->next = sortList(head->next, tail);

      // Sort everything upto head
      head = sortList(smaller, head);
    }
    return head;
  }
};
