class MyQueue {

    private Stack<Integer> addQ;
    private Stack<Integer> removeQ;

    public MyQueue() {
        addQ = new Stack<>();
        removeQ = new Stack<>();
    }
    
    public void push(int x) {
        addQ.push(x);
    }
    
    public int pop() {
        while(!addQ.empty()){
            removeQ.push(addQ.pop());
        }
        int removed = removeQ.pop();
        while(!removeQ.empty()){
            addQ.push(removeQ.pop());
        }
        return removed;
    }
    
    public int peek() {
        while(!addQ.empty()){
            removeQ.push(addQ.pop());
        }
        int peekData = removeQ.peek();
         while(!removeQ.empty()){
            addQ.push(removeQ.pop());
        }
        return peekData;
    }
    
    public boolean empty() {
          return addQ.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */