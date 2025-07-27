//35








/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    struct ListNode* cur = headA;
    struct ListNode* curr = headB;
    while(cur != curr)
    {
        cur = (cur!=NULL)  ? cur->next : headB;
        curr = (curr != NULL)? curr->next : headA;
    }
    return cur;
}







//37ms







/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    struct ListNode *t1 = headA;
    struct ListNode *t2 = headB;

    while(t1 != t2){
        if(t1 == NULL){
            t1 = headB;
        }
        else{
            t1 = t1->next;
        }
        if(t2 == NULL){
            t2 = headA;
        }
        else{
            t2 = t2->next;
        }
    }
    return t2;
}






//44ms






/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void changeSign(struct ListNode *head){
    while ( head )
    {
        head->val *= -1;
        head = head->next;
    }
}
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    changeSign( headA );
        
    while ( headB )
    {
        if ( headB->val < 0 ) break;
        headB = headB->next;
    }
        
    changeSign( headA );
    return headB;
}
