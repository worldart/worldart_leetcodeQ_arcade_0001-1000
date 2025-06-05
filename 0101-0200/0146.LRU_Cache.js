//99ms


/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.capacity = capacity;
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if (!this.cache.has(key)) return -1;
    const value = this.cache.get(key);
    this.cache.delete(key);
    this.cache.set(key, value);
    return value;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    this.cache.delete(key);
    this.cache.set(key, value);
    if (this.cache.size > this.capacity) 
        this.cache.delete(this.cache.keys().next().value);
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */




//88ms





class Node {
    constructor(key, value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    constructor() {
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    addToFront(node) { // after head dummy
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    removeNode(node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    removeFromEnd() {
        if (this.tail.prev === this.head) return null;
        const lru = this.tail.prev;
        this.removeNode(lru);
        return lru;
    }
}
/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.accessOrder = new DoublyLinkedList();
    this.capacity = capacity;
    this.cache = new Map()
};

/** 
 * @param {number} key
 * @return {number}
 */

LRUCache.prototype.get = function(key) {
    if (!this.cache.has(key)) return -1;

    const node = this.cache.get(key);
    this.accessOrder.removeNode(node);
    this.accessOrder.addToFront(node);
    return node.value;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if (this.cache.has(key)) {
        const node = this.cache.get(key);
        node.value = value;
        this.accessOrder.removeNode(node);
        this.accessOrder.addToFront(node);
    } else {
        const node = new Node(key, value);
        this.accessOrder.addToFront(node);
        this.cache.set(key, node);
        if (this.cache.size > this.capacity) {
            const lruNode = this.accessOrder.removeFromEnd();
            this.cache.delete(lruNode.key);
        }
    }
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */





//95ms





/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.capacity = capacity;
    this.map = new Map();

    // Create dummy head and tail nodes for linked list
    this.head = { prev: null, next: null };
    this.tail = { prev: null, next: null };
    this.head.next = this.tail;
    this.tail.prev = this.head;
};

LRUCache.prototype._addNode = function(node) {
    let prev = this.tail.prev;
    prev.next = node;
    node.prev = prev;
    node.next = this.tail;
    this.tail.prev = node;
};

LRUCache.prototype._removeNode = function(node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
};

LRUCache.prototype._moveToEnd = function(node) {
    this._removeNode(node);
    this._addNode(node);
};

LRUCache.prototype.get = function(key) {
    if (!this.map.has(key)) return -1;
    const node = this.map.get(key);
    this._moveToEnd(node);
    return node.value; // Must return value
};

LRUCache.prototype.put = function(key, value) {
    if (this.map.has(key)) {
        const existingNode = this.map.get(key);
        existingNode.value = value;
        this._moveToEnd(existingNode);
    } else {
        const newNode = { key, value, prev: null, next: null };
        this.map.set(key, newNode);
        this._addNode(newNode);

        if (this.map.size > this.capacity) {
            const lru = this.head.next;
            this._removeNode(lru);
            this.map.delete(lru.key);
        }
    }
};


/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
