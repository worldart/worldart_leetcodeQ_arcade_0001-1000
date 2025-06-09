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





//3ms




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

var insertionSortList = function(head) {
    const extracted = extract(head).sort((a,b) => a - b)

    const result = new ListNode()

    let curr = result

    for (const v of extracted) {
        curr.next = new ListNode(v)
        curr = curr.next
    }

    return result.next
};

const extract = (node) => {
    const result = []
    let curr = node
    while (curr) {
        result.push(curr.val)
        curr = curr.next
    }
    return result
}






//5ms






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
	const values = [];
	let node = head;
	while (node) {
		values.push(node.val);
		node = node.next;
	}
	values.sort((a, b) => a - b);
	node = head;
	for (const value of values) {
		node.val = value;
		node = node.next;
	}
	return head;
};

