//52ms

/**
 * // Definition for a _Node.
 * function _Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {_Node} node
 * @return {_Node}
 */
// BFS approach
var cloneGraph = function (node) {
    // BFS approach
    // 1. create a new node
    // 2. add the new node to the queue
    // 3. add the new node to the visited map
    // 4. while the queue is not empty
    // 5.    get the first node from the queue
    // 6.    for each neighbor of the node
    // 7.        if the neighbor is not in the visited map
    // 8.            create a new node
    // 9.            add the new node to the queue
    // 10.           add the new node to the visited map
    // 11.       add the new node to the neighbors of the new node
    if (!node) return null;

    let newNode = new Node(node.val);
    let queue = [node];
    let visited = new Map();
    visited.set(node, newNode);

    while (queue.length > 0) {
        let currentNode = queue.shift();
        for (let neighbor of currentNode.neighbors) {
            if (!visited.has(neighbor)) {
                let newNeighbor = new Node(neighbor.val);
                queue.push(neighbor);
                visited.set(neighbor, newNeighbor);
            }
            visited.get(currentNode).neighbors.push(visited.get(neighbor));
        }
    }
    return newNode;
};





//51ms



/**
 * // Definition for a _Node.
 * function _Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {_Node} node
 * @return {_Node}
 */
// DFS approach
var cloneGraph = function (node) {
    // DFS approach
    // 1. create a new node
    // 2. add the new node to the visited map
    // 3. for each neighbor of the node
    // 4.    if the neighbor is not in the visited map
    // 5.        create a new node
    // 6.        add the new node to the visited map
    // 7.    add the new node to the neighbors of the new node
    if (!node) return null;

    let dfs = (node, visited) => {
        if (visited.has(node)) return visited.get(node);
        let newNode = new Node(node.val);
        visited.set(node, newNode);
        for (let neighbor of node.neighbors) {
            newNode.neighbors.push(dfs(neighbor, visited));
        }
        return newNode;
    }
    return dfs(node, new Map());
}






//50ms





/**
 * // Definition for a _Node.
 * function _Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {_Node} node
 * @return {_Node}
 */
var cloneGraph = function (node) {
    if (node === null) return null;
    let visited = new Map();

    const queue = [node];
    visited.set(node, new Node(node.val))

    while (queue.length) {
        const curr = queue.shift();

        for (let neighbor of curr.neighbors) {
            if (!visited.has(neighbor)) {
                visited.set(neighbor, new Node(neighbor.val));
                queue.push(neighbor)
            }
            visited.get(curr).neighbors.push(visited.get(neighbor))
        }
    }

    return visited.get(node);

    function dfs(current) {
        if (visited.has(current)) return visited.get(current)
        const clone = new Node(current.val);
        visited.set(current, clone);

        for (let neighbor of current.neighbors) {
            clone.neighbors.push(dfs(neighbor))
        }

        return clone;
    }
    

    return dfs(node)
};






