//0ms

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //Head head of current level
        Node head = root;
        while( head != null ){
            Node temp = new Node(0); // To make connections between nodes at the current level
            Node dummy = temp; // Pointer to keep track of the start of the next level
            while( head != null ){
                if( head.left != null ){
                    temp.next = head.left; // Connect left child
                    temp = temp.next; //Move temp forward
                }
                if( head.right != null ){
                    temp.next = head.right; // Connect right child
                    temp = temp.next; //Move temp forward
                }
                head = head.next; // Move to the next node in the current level
            }
            head = dummy.next; // Move to the next level
        }
        return root;
    }
}
