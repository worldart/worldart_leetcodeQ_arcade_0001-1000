// 15ms




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

#include <iostream>
using namespace std;
//takesoumen collection
class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) return head;
        
        // Find the middle using slow and fast pointers
        ListNode* slow = head;
        ListNode* fast = head->next;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        ListNode* mid = slow->next;
        slow->next = nullptr;
        
        // Recursively split and merge
        ListNode* left = sortList(head);
        ListNode* right = sortList(mid);
        
        return merge(left, right);
    }
    
    ListNode* merge(ListNode* l1, ListNode* l2) {
        ListNode dummy(0);
        ListNode* tail = &dummy;
        
        while (l1 && l2) {
            if (l1->val < l2->val) {
                tail->next = l1;
                l1 = l1->next;
            } else {
                tail->next = l2;
                l2 = l2->next;
            }
            tail = tail->next;
        }
        
        tail->next = l1 ? l1 : l2;
        return dummy.next;
    }
};


//23ms



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
    ListNode* sortList(ListNode* head) {
        // use merge sort
        // cut list into two
        
        // base case
        if(head==nullptr || head->next == nullptr) return head;

        ListNode *slow = head;
        ListNode *fast = head;
        ListNode *prev;
        while(fast && fast->next)
        {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        prev->next = nullptr;

        // recursion
        ListNode *l1 = sortList(head);
        ListNode *l2 = sortList(slow);

        return mergeList(l1, l2);
    }

    ListNode* mergeList(ListNode* l1, ListNode* l2)
    {
        ListNode dummy(0);
        ListNode *curr = &dummy;

        while(l1 && l2)
        {
            if(l1->val < l2->val)
            {
                curr->next = l1;
                curr = curr->next;
                l1 = l1->next;
            }
            else
            {
                curr->next = l2;
                curr = curr->next;
                l2 = l2->next;
            }
        }

        if(l1) curr->next = l1;
        if(l2) curr->next = l2;
        
        return dummy.next;
    }
};



//13ms





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
private:
    ListNode* middle(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* prev = nullptr;
        while (fast && fast->next) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        return prev;
    }

    ListNode* merge(ListNode* head1, ListNode* head2) {
        ListNode dummy(0);
        ListNode* tail = &dummy;
        while (head1 && head2) {
            if (head1->val < head2->val) {
                tail->next = head1;
                head1 = head1->next;
            } else {
                tail->next = head2;
                head2 = head2->next;
            }
            tail = tail->next;
        }
        if (head1) tail->next = head1;
        if (head2) tail->next = head2;
        return dummy.next;
    }

public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode* midPrev = middle(head);
        ListNode* right = midPrev->next;
        midPrev->next = nullptr;
        ListNode* left = sortList(head);
        right = sortList(right);
        return merge(left, right);
    }
};
