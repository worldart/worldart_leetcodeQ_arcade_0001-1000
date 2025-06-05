//58ms



use std::collections::HashMap;

/// Sentinel value of -1 for dropped heap positions; 0 <= key <= 10^4
#[derive(PartialEq, Clone)]
struct FLLVal(i16);
const FLLSentinel: FLLVal = FLLVal(-1);
#[derive(PartialEq, Clone, Copy)]
struct FLLIndex(usize);

struct FlatLinkList {
    heap: Vec<(FLLVal, Option<FLLIndex>, Option<FLLIndex>)>,
    head: Option<FLLIndex>,
    tail: Option<FLLIndex>,
    last_dropped: Option<FLLIndex>,
}

impl FlatLinkList {
    pub fn new(capacity: i32) -> Self {
        FlatLinkList {
            heap: vec![(FLLSentinel, None, None); capacity as usize],
            head: None,
            tail: None,
            last_dropped: None,
        }
    }

    pub fn drop_and_push(&mut self, idx: FLLIndex) -> FLLIndex {
        let val = self.heap[idx.0].0.clone();

        let orig_right = self.heap[idx.0].2;
        if orig_right == None {
            // No action required
            return idx;
        }
        let orig_right = orig_right.unwrap();

        let orig_left = self.heap[idx.0].1;
        if orig_left == None {
            self.head = Some(orig_right);
            self.heap[orig_right.0].1 = None;
        } else {
            // Normal stitching routine
            let orig_left = orig_left.unwrap();
            self.heap[orig_left.0].2 = Some(orig_right);
            self.heap[orig_right.0].1 = Some(orig_left);
        }

        self.heap[idx.0] = (FLLSentinel, None, None);
        self.last_dropped = Some(idx);
        self.push_back(val.0)
    }

    pub fn pop_front(&mut self) -> FLLVal {
        if self.tail == self.head {
            self.tail = None;
        }
        let dropped_idx = self.head.unwrap();
        self.last_dropped = Some(dropped_idx);
        let next = self.heap[dropped_idx.0].2;
        let val = self.heap[dropped_idx.0].0.clone();
        self.heap[dropped_idx.0].0 = FLLSentinel;
        if next != None {
            self.heap[next.unwrap().0].1 = None;
        }
        self.head = next;
        val
    }

    pub fn next_free(&mut self) -> FLLIndex {
        if self.last_dropped == None {
            FLLIndex(self.heap.iter().position(|z| z.0 == FLLSentinel).expect("Heap overflow"))
        } else {
            let idx = self.last_dropped.unwrap().clone();
            self.last_dropped = None;
            idx
        }

    }

    pub fn push_back(&mut self,val: i16) -> FLLIndex {
        match self.tail {
            Some(tail_idx) => {
                let new_idx = self.next_free();
                self.heap[new_idx.0] = (FLLVal(val), Some(tail_idx), None);
                self.heap[tail_idx.0].2 = Some(new_idx);
                self.tail = Some(new_idx);
                new_idx
            },
            None => {
                let new_idx = Some(FLLIndex(0));
                self.head = new_idx; self.tail = new_idx;
                self.heap[0] = (FLLVal(val), None, None);
                new_idx.unwrap()
            }
        }
    }
}

struct LRUCache {
    map: HashMap<i32, (i32, FLLIndex)>,
    cap: usize,
    list: FlatLinkList,
}

/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl LRUCache {
    fn new(capacity: i32) -> Self {
        LRUCache {
            map: HashMap::with_capacity(capacity as usize),
            cap: capacity as usize,
            list: FlatLinkList::new(capacity),
        }
    }
    
    fn get(&mut self, key: i32) -> i32 {
        //println!("Get ({key})");
        if self.map.contains_key(&key) {
            let fetch = self.map.get_mut(&key).expect("");
            let new_idx = self.list.drop_and_push(fetch.1);
            fetch.1 = new_idx;
            //println!("Eviction list: {:?}", self.list);
            fetch.0
        } else {
            -1
        }
    }
    
    fn put(&mut self, key: i32, value: i32) {
        //println!("Put ({key}, {value})");
        let final_idx = match self.map.get(&key) {
            Some(tup) => {
                //println!("Drop and push");
                let idx = tup.1;
                self.list.drop_and_push(idx)
            },
            None => {
                //println!("Simple push");
                if self.map.len() >= self.cap { self.evict_oldest(); }
                self.list.push_back(key as i16)
            },
        };
        
        //println!("Eviction list: {:?}", self.list);
        self.map.insert(key, (value, final_idx));
    }

    fn evict_oldest(&mut self) {
        //println!("Performing eviction");
        let oldest = self.list.pop_front();
        
        //println!("Eviction list: {:?}", self.list);
        self.map.remove(&(oldest.0 as i32));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * let obj = LRUCache::new(capacity);
 * let ret_1: i32 = obj.get(key);
 * obj.put(key, value);
 */




//48ms





use std::rc::Rc;
use std::cell::RefCell;
use std::collections::HashMap;

struct Node {
    key: i32,
    value: i32,
    prev: Option<Rc<RefCell<Node>>>,
    next: Option<Rc<RefCell<Node>>>,
}

struct LRUCache {
    hash_map: HashMap<i32, Rc<RefCell<Node>>>,
    capacity: i32,
    mru: Option<Rc<RefCell<Node>>>,
    lru: Option<Rc<RefCell<Node>>>,
}

/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl LRUCache {

    fn new(capacity: i32) -> Self {
        Self {
            hash_map: std::collections::HashMap::new(),
            capacity: capacity,
            mru: None,
            lru: None,
        }
    }
    
    fn get(&mut self, key: i32) -> i32 {
        match self.hash_map.get_mut(&key) {
            Some(node) => {
                if !Rc::ptr_eq(node, &self.mru.clone().unwrap()) {
                    if Rc::ptr_eq(node, &self.lru.clone().unwrap()) {
                        if let Some(prev) = node.borrow().prev.clone() {
                            self.lru = Some(prev);
                        }
                    }
                    {
                        let mut node = node.borrow_mut();
                        if let Some(next) = &node.next {
                            next.borrow_mut().prev = node.prev.clone();
                        }
                        if let Some(prev) = &node.prev {
                            prev.borrow_mut().next = node.next.clone();
                        }
                        node.prev = None;
                        node.next = self.mru.clone();
                    }
                    if let Some(next) = &self.mru {
                        next.borrow_mut().prev = Some(node.clone());
                    }
                    self.mru = Some(node.clone());
                                }

                (*node).borrow().value
            },
            None => -1,
        }
    }
    
    fn put(&mut self, key: i32, value: i32) {
        if let Some(node) = self.hash_map.get_mut(&key) {
            if !Rc::ptr_eq(node, &self.mru.clone().unwrap()) {
                if Rc::ptr_eq(node, &self.lru.clone().unwrap()) {
                    if let Some(prev) = node.borrow().prev.clone() {
                        self.lru = Some(prev);
                    }
                }
                {
                    let mut node = node.borrow_mut();
                    if let Some(next) = &node.next {
                        next.borrow_mut().prev = node.prev.clone();
                    }
                    if let Some(prev) = &node.prev {
                        prev.borrow_mut().next = node.next.clone();
                    }
                    node.prev = None;
                    node.next = self.mru.clone();
                }
                if let Some(next) = &self.mru {
                    next.borrow_mut().prev = Some(node.clone());
                }
                self.mru = Some(node.clone());
                        }
            node.borrow_mut().value = value;
            return;
        }
        
        let node = Rc::new(RefCell::new(Node {
            key: key,
            value: value,
            prev: None,
            next: self.mru.clone(),
        }));
        if let Some(next) = &self.mru {
            next.borrow_mut().prev = Some(node.clone());
        }
        self.mru = Some(node.clone());
        if self.lru.is_none() {
            self.lru = Some(node.clone());
        }
        self.hash_map.insert(key, node.clone());

        if self.hash_map.len() > self.capacity as usize {
            let lru = self.lru.clone().unwrap();
            let lru = lru.borrow();
            self.hash_map.remove(&lru.key);
            if let Some(prev) = &lru.prev {
                prev.borrow_mut().next = None;
            }
            self.lru = lru.prev.clone();
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * let obj = LRUCache::new(capacity);
 * let ret_1: i32 = obj.get(key);
 * obj.put(key, value);
 */
