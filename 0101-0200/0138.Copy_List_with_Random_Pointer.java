//0ms




/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hashMap = new HashMap<>();
        Node cur = head;

        while (cur != null) {
            hashMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            Node copy = hashMap.get(cur);
            copy.next = hashMap.get(cur.next);
            copy.random = hashMap.get(cur.random);
            cur = cur.next;
        }

        return hashMap.get(head);        
    }
}




//1ms





/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> nodeToLocation = new HashMap<>();
        HashMap<Integer, Node> locationToNode = new HashMap<>();
        
        Node pointer = head;
        Node newList = null;
        int locNumber = 0;
        while(pointer!=null){
            nodeToLocation.put(pointer, locNumber);
            Node newElem = new Node(pointer.val);
            locationToNode.put(locNumber, newElem);
            if(newList == null) newList = newElem;
            else {
                locationToNode.get(locNumber-1).next = newElem;
            }
            locNumber++;
            pointer = pointer.next;
        }
        pointer = head;
        while(pointer!=null) {
            if(pointer.random==null) {
                pointer = pointer.next;
                continue;
            }
            int locThis = nodeToLocation.get(pointer);
            int locRandom = nodeToLocation.get(pointer.random);
            locationToNode.get(locThis).random = locationToNode.get(locRandom);
            pointer = pointer.next;
        }
        return newList;
    }
}
