//0ms

struct ListNode* deleteDuplicates(struct ListNode* head) {
    if (!head || !head->next)
        return head;

    struct ListNode dummy;
    dummy.next = head;

    struct ListNode* current = &dummy;
    while (current->next && current->next->next) {
        if (current->next->val == current->next->next->val) {
            int duplicate = current->next->val;
            while (current->next && current->next->val == duplicate)
                current->next = current->next->next;
        } else {
            current = current->next;
        }
    }
    return dummy.next;
}
