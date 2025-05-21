//50ms



var copyRandomList = function(head) {
    const hashMap = new Map();
    let cur = head;

    while (cur) {
        hashMap.set(cur, new Node(cur.val));
        cur = cur.next;
    }

    cur = head;

    while (cur) {
        const copy = hashMap.get(cur);
        copy.next = hashMap.get(cur.next) || null;
        copy.random = hashMap.get(cur.random) || null;
        cur = cur.next;
    }

    return hashMap.get(head);   
};




//41ms




/**
 * // Definition for a _Node.
 * function _Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {_Node} head
 * @return {_Node}
 */
var copyRandomList = function(head) {
    const visited = new Map();

    function cloneNode (node) {
        if (node === null) return null;

        if (visited.has(node)) return visited.get(node);

        const clone = new _Node(node.val);
        visited.set(node, clone);

        clone.next = cloneNode(node.next);
        clone.random = cloneNode(node.random);
        
        return clone;
    }

    return cloneNode(head);
};





//47ms






/**
 * // Definition for a _Node.
 * function _Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {_Node} head
 * @return {_Node}
 */
var copyRandomList = function(head) {
    // create nodes interleaved
    // attach random link
    // separate the list
    if (!head) {
        return null
    }
    let l1 = head
    while (l1) {
        const newNode = new _Node(l1.val)
        newNode.next = l1.next
        l1.next = newNode
        l1 = newNode.next
    }
    l1 = head
    while (l1) {
        if (l1.random) {
            l1.next.random = l1.random.next
        }
        l1 = l1.next.next
    }
    l1 = head
    const l2 = head.next
    while (l1) {
        const newNode = l1.next
        l1.next = newNode.next
        newNode.next = newNode.next ? newNode.next.next : null
        l1 = l1.next
    }
    return l2
};


