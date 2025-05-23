class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();
    int mini = Integer.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int val) {
        s.push(val);
        mini = min.isEmpty() ? val : Math.min(min.peek(), val);
        min.push(mini);
    }
    
    public void pop() {
        s.pop();
        min.pop();
        mini = min.isEmpty() ? Integer.MAX_VALUE : min.peek();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

