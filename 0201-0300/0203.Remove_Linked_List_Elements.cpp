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
    ListNode* removeElements(ListNode* head, int val) {
        if(head == nullptr) return nullptr;

        head->next = removeElements(head->next , val);
        
        return (head->val == val) ? head->next : head;
    }
};







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
    ListNode* removeElements(ListNode* head, int val) {
        if(head == nullptr){
            return head;
        }    
        ListNode* dummy=new ListNode(0);
        ListNode* back=dummy;
        back->next=head;
        while(head!=nullptr){
            if(head->val == val){
                back->next=head->next;
            
            }
            else{
                back=head;
            }
            head=head->next;
            
        }
        return dummy->next;
    }
};






























