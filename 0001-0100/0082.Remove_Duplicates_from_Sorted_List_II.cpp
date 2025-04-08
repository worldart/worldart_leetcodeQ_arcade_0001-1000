//0ms

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head || !head->next) return head; // If list is empty or has one node, return it

        ListNode* dummy = new ListNode(0); // Dummy node before head
        dummy->next = head;
        ListNode* prev = dummy; // Pointer to track last non-duplicate node

        while (head) {
            if (head->next && head->val == head->next->val) {
                // Move head forward while there are duplicates
                while (head->next && head->val == head->next->val) {
                    head = head->next;
                }
                // Skip all duplicates
                prev->next = head->next;
            } else {
                prev = prev->next; // Move prev only if there's no duplicate
            }
            head = head->next; // Move head forward
        }

        return dummy->next;

    }
};
