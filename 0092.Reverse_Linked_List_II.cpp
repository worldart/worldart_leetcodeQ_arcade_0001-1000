//0ms


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
    // Helper function to reverse the linked list
    ListNode* reverseLL(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode* last = reverseLL(head->next);
        head->next->next = head;
        head->next = nullptr;
        return last;
    }

    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if (left == right || !head) return head;
        
        // Dummy node to handle edge cases
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* prev = dummy;

        // Move to the node before the 'left' position
        for (int i = 1; i < left; ++i) {
            prev = prev->next;
        }

        // Identify the start and end of the sublist
        ListNode* start = prev->next;
        ListNode* end = start;
        for (int i = left; i < right; ++i) {
            end = end->next;
        }

        // Save the remaining list after 'right'
        ListNode* rest = end->next;
        end->next = nullptr; // Detach sublist

        // Reverse the sublist
        ListNode* reversed = reverseLL(start);

        // Reconnect the reversed sublist back to the main list
        prev->next = reversed;
        start->next = rest;

        return dummy->next; // Return the modified list
    }
};
