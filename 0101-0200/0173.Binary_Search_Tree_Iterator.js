//10ms





/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 */
var BSTIterator = function (root) {
    this.parents = []

    while (root) {
        this.parents.push(root)
        root = root.left
    }
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function () {
    let cur = this.parents.pop()
    const val = cur.val
    if (cur.right) {
        cur = cur.right
        while (cur) {
            this.parents.push(cur)
            cur = cur.left
        }
    }
    return val
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function () {
    return this.parents.length > 0
};

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */





//9ms






/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 */



function BSTIterator(root) {
  var stack = [];
  return {hasNext, next};
/**
 * @return {number}
 */
  function hasNext() {
    return root || stack.length;
  }

/**
 * @return {boolean}
 */

  function next() {
    while (root) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    var result = root.val;
    root = root.right;
    return result;
  }
}

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */





//9ms






/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
// /**
//  * @param {TreeNode} root
//  */
// var BSTIterator = function(root) {
//     this.inorder = [];
//     this.index = 0;

//     // Precompute inorder traversal
//     const stack = [];
//     let curr = root;
//     while (curr || stack.length) {
//         while (curr) {
//             stack.push(curr);
//             curr = curr.left;
//         }
//         curr = stack.pop();
//         this.inorder.push(curr.val);
//         curr = curr.right;
//     }
// };

// /**
//  * @return {number}
//  */
// BSTIterator.prototype.next = function() {
//     return this.inorder[this.index++];
// };

// /**
//  * @return {boolean}
//  */
// BSTIterator.prototype.hasNext = function() {
//     return this.index < this.inorder.length;
// };


/**
 * @param {TreeNode} root
 */
var BSTIterator = function(root) {
    this.stack = [];
    this.pushAll(root);
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function() {
    const element = this.stack.pop();
    this.pushAll(element.right);
    return element.val;
};

/**
 * @param {TreeNode} node
 * @return {void}
 */
BSTIterator.prototype.pushAll = function(node) {
    while(node) {
        this.stack.push(node);
        node = node.left;
    }
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
    return this.stack.length > 0;
};

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
