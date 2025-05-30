//50ms




/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */



var detectCycle = function (head) {
    if(!head || !head.next) return null;
    let fast = head, slow = head;

    while (fast && fast.next) {
        slow = slow.next, fast = fast.next.next;
        if (slow === fast) {
            break;
        }
    }

    if (slow === fast) {
        slow = head;
        while (slow !== fast) {
            slow = slow.next;
            fast = fast.next;

        }
        return slow;
    }
    return null;
};




//46ms





/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {

    if(!head) return null
    if(!head.next) return null

    let slow = head ; 
    let fast = head ;

    while (fast!== null && fast.next!== null){
        slow = slow.next ;
        fast = fast.next.next ;
        if(slow == fast){
            let entry = head ; 
            while(entry != slow){
                entry = entry.next
                slow = slow.next
            }
            return entry
        }
    }
    return null

};





//34ms





/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {

    /* so for this we are going to detect a cycle by using the tortoise and the hare concept
    which is using two pointers and traversing through the LL one by +1 and the other by +2 so
    if pointer one equals pointer two we know we have a loop
    if the fastpointer.next is null then we exit the loop it means there was an end or if fastpointer = null
    */
    let slow = head;
    let fast = head;

    while (true) {
        if (fast === null || fast.next === null) return null

        slow = slow.next;
        fast = fast.next.next;

        if (slow === fast) break;
    }

    // Now we know there is a cycle, and we know the start of the cycle exists where the pointer meet
    // again if we reset one to the head and incremenet them both by 1

    // reset slow to the head
    slow = head;

    while (slow !== fast) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow;    
};
