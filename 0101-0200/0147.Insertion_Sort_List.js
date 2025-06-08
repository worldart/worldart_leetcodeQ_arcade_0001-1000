//36ms





/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var insertionSortList = function (head) {
    if (!head || !head.next) return head;
    const bucket = new ListNode(-Infinity, null);

    function insert(el) {
        let prev = bucket;
        while (prev.next && prev.next.val < el.val) {
            prev = prev.next;
        }
        [el.next, prev.next] = [prev.next, el];
    }

    let node = head;
    while (node) {
        const nextNode = node.next;
        insert(node);
        node = nextNode;
    }
    return bucket.next;
};
