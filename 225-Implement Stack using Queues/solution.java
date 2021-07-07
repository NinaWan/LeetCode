class MyStack {
    private LinkedList<Integer> queue;
    private int top = 0;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }

        top = queue.peek();
        queue.offer(queue.poll());

        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */