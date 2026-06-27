class MinStack {
   Stack<Integer> st;
   Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if (minSt.size()==0 || minSt.peek() >= value) minSt.push(value);
    }
    
    public void pop() {
        if (st.size()==0) return;
       int ele =  st.pop();
       if (ele == minSt.peek()) minSt.pop();
    }
    
    public int top() {
        if (st.size()==0) return -1;
        return st.peek();
    }
    
    public int getMin() {
        if (minSt.size()==0) return -1;
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */