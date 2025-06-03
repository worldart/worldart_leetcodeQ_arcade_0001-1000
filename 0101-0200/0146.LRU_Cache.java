//50ms


class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> m = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newnode) {
        Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }

    private void deleteNode(Node delnode) {
        Node prevv = delnode.prev;
        Node nextt = delnode.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            Node resNode = m.get(key);
            int ans = resNode.val;

            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            m.put(key, head.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);
        }

        if (m.size() == cap) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        m.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




//32ms





class LRUCache {
    class Node{//DLL 
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key= key;
            this.value= value;
        }
    }

    public Node[] map;//stores each node metatdata reff w.r.t to key
    public int count, capacity;
    public Node head, tail;
    
    public LRUCache(int capacity) { //all nodes are inserded b/w head and tail node 
        
        this.capacity= capacity;
        count= 0;
        
        map= new Node[10_000+1];//no of nodes //metadata w.r.t. to key 
        
        head= new Node(0,0);
        tail= new Node(0,0);
        
        head.next= tail;
        tail.prev= head;
        
        head.prev= null;
        tail.next= null;
    }
    
    public void deleteNode(Node node){ // deleting the node in LRU cache 
        node.prev.next= node.next;
        node.next.prev= node.prev;       
        
        return;
    }
    
    public void addToHead(Node node){// adding the node in front of head i.e;in LRU cache 
        node.next= head.next;
        node.next.prev= node;
        node.prev= head;
        
        head.next= node;      
        
        return;
    }
    
    public int get(int key) { // O(1)
        
        if( map[key] != null ){ //if node is present in LRU cache 
            
            Node node= map[key];//getting the node metadata 
            
            int nodeVal= node.value;
            
            deleteNode(node);//deleting the node from dll //O(1)
            
            addToHead(node);//adding to the front of head //now visited //O(1)
            
            return nodeVal;//returning the value of the node w.r.t to key 
        }
        else
            return -1;//node not present 
    }
    
    public void put(int key, int value) { // O(1)
        
        if(map[key] != null){//node already exists in LRU cache 
            
            Node node= map[key]; //getting the node metadata
            
            node.value= value;//changing the node value to the current value 
            
            deleteNode(node);//deleting the node  //O(1)
            
            addToHead(node);//adding node in front of head  //O(1)
            
        } else {//node dosent  exists in LRU cache 
            
            Node node= new Node(key,value);
            
            map[key]= node;
            
            if(count < capacity){ //Case 1 //space availabe 
                count++;
                addToHead(node);
            } 
            else {//case 2 //space not availabe (capacity full)
                
                //deleting the least recently used node, making 1 sapce availabele
                map[tail.prev.key]= null;
                deleteNode(tail.prev);
                
                //adding the node in front of head
                addToHead(node);
            }
        }
        
        return;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */












