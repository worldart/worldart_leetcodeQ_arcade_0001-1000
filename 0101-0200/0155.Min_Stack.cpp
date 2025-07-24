//4ms




class MinStack {
public:
    stack<int> st, min_st;
    MinStack() {
        
    }
    
    void push(int val) {
        st.push(val);
        if(min_st.empty())
            min_st.push(val);
        else if(min_st.top() >= val)
            min_st.push(val);
    }
    
    void pop() {
        if(st.top() == min_st.top())
            min_st.pop();
        st.pop();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return min_st.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */






//7ms





class MinStack {
public:
stack<pair<int,int>>st;
    MinStack() {
        
    }
    
    void push(int val) {
        int mini;
        if(st.empty()){
            mini=val;
        }
        else{
            mini = min(val, st.top().second);

        }
        st.push({val,mini});
    }
    
    void pop() {
        st.pop();
    }
    
    int top() {
        if(st.empty())return -1;
        int v = st.top().first;
        return v; 
    }
    
    int getMin() {
        if (st.empty()) return -1;
        int m = st.top().second;
        return m;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */






//0ms






class MinStack {
private:
    stack<long long> st;
    long long minVal;

public:
    MinStack() {
        minVal = 0;
    }
    
    void push(int val) {
        if (st.empty()) {
            st.push(val);
            minVal = val;
        } else {
            if (val >= minVal) {
                st.push(val);
            } else {
                st.push(2LL * val - minVal); 
                minVal = val;
            }
        }
    }
    
    void pop() {
        if (st.empty()) return;

        long long top = st.top();
        st.pop();
        if (top < minVal) {
            minVal = 2 * minVal - top; 
        }
    }
    
    int top() {
        if (st.empty()) return -1;

        long long top = st.top();
        if (top >= minVal)
            return top;
        else
            return minVal;
    }
    
    int getMin() {
        return minVal;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */


