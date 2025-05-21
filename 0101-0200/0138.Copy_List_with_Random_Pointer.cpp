//7ms




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
public:
    Node* copyRandomList(Node* head) {
        map<Node*, Node*> m;
        int i=0;
        Node* ptr = head;
        while (ptr) {
            m[ptr] =new Node(ptr->val);
            ptr = ptr->next;
        }
        ptr = head;
        while (ptr) {
            m[ptr]->next = m[ptr->next];
            m[ptr]->random = m[ptr->random];
            ptr = ptr->next;
        }
        return m[head];
    }
};





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
public:
    Node* copyRandomList(Node* head) {
        std::unordered_map<Node*, Node*> hashMap;
        Node* cur = head;

        while (cur) {
            hashMap[cur] = new Node(cur->val);
            cur = cur->next;
        }

        cur = head;

        while (cur) {
            Node* copy = hashMap[cur];
            copy->next = hashMap[cur->next];
            copy->random = hashMap[cur->random];
            cur = cur->next;
        }

        return hashMap[head];        
    }
};




//4ms





/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head == NULL ) return nullptr;

        unordered_map<Node*,Node*> map;
        Node* temp = head;
        Node*  head2 = new Node(-1);
        Node* prev = head2;


        while(temp){
            Node* ans = new Node(temp->val);
            map[temp]=ans;
            prev->next = ans;
            prev = ans;
            temp = temp->next;
            
        }

        temp = head;
        Node* temp2 = head2->next;
        while(temp){
        if(temp->random) temp2->random = map[temp->random];
        temp2=temp2->next;
        temp=temp->next;
            
        }

        return head2->next;
        
    }
};

