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




//2ms








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
function sortList(head) {
  // Trivial or single-node list
  if (head === null || head.next === null) {
    return head;
  }

  // 1. Single scan to find min/max
  let minimumValue = head.val;
  let maximumValue = head.val;
  let currentNode = head;
  while (currentNode !== null) {
    const value = currentNode.val;
    if (value < minimumValue) {
      minimumValue = value;
    } else if (value > maximumValue) {
      maximumValue = value;
    }
    currentNode = currentNode.next;
  }

  // 2. Prepare counts
  const valueOffset = -minimumValue;
  const bucketCount = maximumValue - minimumValue + 1;
  const frequencyCounts = new Uint32Array(bucketCount);

  // 3. Second scan to tally frequencies
  currentNode = head;
  while (currentNode !== null) {
    frequencyCounts[currentNode.val + valueOffset]++;
    currentNode = currentNode.next;
  }

  // 4. Third pass: write back in order
  let writePointer = head;
  for (let bucketIndex = 0; bucketIndex < bucketCount; ++bucketIndex) {
    let occurrences = frequencyCounts[bucketIndex];
    if (occurrences === 0) {
      continue;
    }

    const sortedValue = bucketIndex - valueOffset;
    while (occurrences-- > 0) {
      writePointer.val = sortedValue;
      writePointer = writePointer.next;  // Safe: total counts == node count
    }
  }

  return head;
}


