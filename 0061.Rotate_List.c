//100%RT

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    
    struct ListNode* temp=head;
    struct ListNode* temp1;
    struct ListNode* flag=head; // flag is used to determine current head
    if(head==NULL || head->next==NULL)
    {
        return head;
    }
    int cnt = 1;
        
    while(head->next != NULL){
        head = head->next;
        cnt++;
    }
    // in case of when k is very large then for reduce no of operation, example:- k=3 and i found cnt(size)=3, 3%3=0
    // so no need to do anything no operation need(0 time) after k(3) opration its also give same result
   k= k % cnt;
    for(int i=0;i<k;i++)
    {
        while(temp->next!=NULL)
        {
            temp1=temp; // Store previous node of last node
            temp=temp->next;
        }
        temp->next=flag; // last node make head,by assing head to the next part of last node according to question
        temp1->next=NULL; //last node previous node is to be last node so next part assign by NULL.
        flag=temp;
       
    }
    return flag;

}
