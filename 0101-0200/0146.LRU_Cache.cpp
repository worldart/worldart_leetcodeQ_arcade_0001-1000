//123ms



class LRUCache {
public:
    class Node{
        public: 
            int key;
            int val;
            Node* prev;
            Node* next;

            Node(int key, int val){
                this->key = key;
                this->val = val;
            }
    };

    Node* head = new Node(-1, -1);
    Node* tail = new Node(-1, -1);

    int cap;
    unordered_map<int, Node*> m;

    LRUCache(int capacity) {
        cap = capacity;
        head -> next = tail;
        tail -> prev = head;
    }

    void addNode(Node* newnode){
        Node* temp = head -> next;

        newnode -> next = temp;
        newnode -> prev = head;

        head -> next = newnode;
        temp -> prev = newnode;
    }

    void deleteNode(Node* delnode){
        Node* prevv = delnode -> prev;
        Node* nextt = delnode -> next;

        prevv -> next = nextt;
        nextt -> prev = prevv;
    }
    
    int get(int key) {
        if(m.find(key) != m.end()){
            Node* resNode = m[key];
            int ans = resNode -> val;

            m.erase(key);
            deleteNode(resNode);
            addNode(resNode);

            m[key] = head -> next;
            return ans;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(m.find(key) != m.end()){
            Node* curr = m[key];
            m.erase(key);
            deleteNode(curr);
        }

        if(m.size() == cap){
            m.erase(tail -> prev -> key);
            deleteNode(tail -> prev);
        }

        addNode(new Node(key, value));
        m[key] = head -> next;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */




//75ms







class LRUCache {
public:
class Node {
    public : 
    int key , value;
    Node* prev , *next;
    Node(int key , int value){
        this->key = key;
        this->value = value;
        next = NULL;
        prev = NULL;
    }
};
int capacity ;
unordered_map<int,Node*> mp;
Node* head = new Node(-1,-1);
Node* tail = new Node(-1,-1);
    LRUCache(int capacity) {
        this->capacity = capacity;
        head->next = tail;
        tail->prev = head;
    }

    void deleteNode(Node* node){
        node->prev->next = node->next;
        node->next->prev = node->prev;
    }

    void insertAtHead(Node* node){
       
        Node* temp = head->next;
        head->next = node;
        node->prev = head; 

        node->next = temp;
        temp->prev = node;
    }
    
    int get(int key) {
        if(mp.find(key)==mp.end()){
            return -1;
        }
        Node* curr = mp[key];
        deleteNode(curr);
        insertAtHead(curr);
        return curr->value;
    }
    
    void put(int key, int value) {
        if(mp.find(key)!=mp.end()){
            Node* curr = mp[key];
            curr->value = value;
            deleteNode(curr);
            insertAtHead(curr);
        }
        else {
            Node* newNode = new Node(key,value);
            if(mp.size()==capacity){
                Node* to_del = tail->prev;
                mp.erase(to_del->key);
                deleteNode(tail->prev);
                insertAtHead(newNode);
                mp[key] = newNode;
                delete to_del;
            }
            else{
                insertAtHead(newNode);
                mp[key] = newNode;
            }
        }   
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */





//61ms






class LRUCache {
public:
    vector<int>fre, val;
    int cap, cur;
    queue<int>q;
    LRUCache(int capacity) {
        cap=capacity;
        cur=0;
        fre.assign(1e4+1, 0);
        val.assign(1e4+1, -1);
    }
    
    int get(int key) {
        if(val[key]!=-1) q.push(key), fre[key]++;
        return val[key];
    }
    
    void put(int key, int value) {
        if(val[key]==-1)
        {
            while(cur>=cap)
            {
                int oldest=q.front();q.pop();
                fre[oldest]--;
                if(fre[oldest]==0)
                {
                    val[oldest]=-1;
                    cur--;
                }
            }
            cur++;
        }
        val[key]=value;
        fre[key]++;
        q.push(key);
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */





