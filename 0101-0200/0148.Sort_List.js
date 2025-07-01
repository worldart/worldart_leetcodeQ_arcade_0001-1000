//23ms


/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
function ListNode(val, next = null) {
    this.val = val;
    this.next = next;
}

var sortList = function(head) {
    if (!head || !head.next) return head;

    const mid = getMid(head);
    const left = sortList(head);
    const right = sortList(mid);

    return merge(left, right);
};

function getMid(head) {
    let slow = head, fast = head, prev = null;
    while (fast && fast.next) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    prev.next = null;
    return slow;
}

function merge(left, right) {
    const dummy = new ListNode(0);
    let tail = dummy;

    while (left && right) {
        if (left.val < right.val) {
            tail.next = left;
            left = left.next;
        } else {
            tail.next = right;
            right = right.next;
        }
        tail = tail.next;
    }

    tail.next = left || right;
    return dummy.next;
}









