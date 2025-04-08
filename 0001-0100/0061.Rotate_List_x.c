//100%RT

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    if(head == NULL || head->next == NULL)
        return head;
    struct ListNode *p = head;
    int i = 0, n = 0;
    while(p->next) {
        p = p->next;
        n++;   
    }
    n++;
    p->next = head;
    while(i < n - (k % n)) {
        head = head->next;
        i++;
    }
    p = head;
    while(p->next != head)
        p = p->next;
    p->next = NULL;
    return head;
}
