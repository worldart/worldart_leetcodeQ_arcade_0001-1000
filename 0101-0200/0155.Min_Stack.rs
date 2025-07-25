//6ms





struct MinStack {
    s: Vec<(i32, i32)>
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MinStack {

    fn new() -> Self {
        MinStack {
            s: Vec::with_capacity(30000)
        }
    }
    
    fn push(&mut self, val: i32) {
        if self.s.is_empty() {
            self.s.push((val, val));
        } else {
            let min = std::cmp::min(val, self.s[self.s.len() - 1].1);
            self.s.push((val, min));
        }
    }
    
    fn pop(&mut self) {
        self.s.pop();
    }
    
    fn top(&self) -> i32 {
        self.s.last().unwrap().0
    }
    
    fn get_min(&self) -> i32 {
        self.s.last().unwrap().1
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * let obj = MinStack::new();
 * obj.push(val);
 * obj.pop();
 * let ret_3: i32 = obj.top();
 * let ret_4: i32 = obj.get_min();
 */




//0ms






/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
#[derive(Clone, Debug)]
struct MinStackEntry {
    val: i32,
    count: i32,
}

struct MinStack {
    st: Vec<i32>,
    min_st: Vec<MinStackEntry>,
}

impl MinStack {
    fn new() -> Self {
        Self {
            st: Vec::new(),
            min_st: Vec::new(),
        }
    }

    fn push(&mut self, val: i32) {
        self.st.push(val);

        match self.min_st.last_mut() {
            Some(min_entry) => {
                if val < min_entry.val {
                    self.min_st.push(MinStackEntry { val, count: 1 });
                } else if val == min_entry.val {
                    min_entry.count += 1;
                }
            }
            None => {
                self.min_st.push(MinStackEntry { val, count: 1 });
            }
        }
    }

    fn pop(&mut self) {
        if let Some(top) = self.st.pop() {
            if let Some(min_entry) = self.min_st.last_mut() {
                if min_entry.val == top {
                    min_entry.count -= 1;
                    if min_entry.count == 0 {
                        self.min_st.pop();
                    }
                }
            }
        }
    }

    fn top(&self) -> i32 {
        *self.st.last().unwrap()
    }

    fn get_min(&self) -> i32 {
        self.min_st.last().unwrap().val
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * let obj = MinStack::new();
 * obj.push(val);
 * obj.pop();
 * let ret_3: i32 = obj.top();
 * let ret_4: i32 = obj.get_min();
 */
