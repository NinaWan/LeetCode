class MyQueue {
    private Stack<Integer> reverse = new Stack<Integer>();
    private Stack<Integer> positive = new Stack<Integer>();
    private Stack<Integer> temp = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        positive.push(x);
        while(!reverse.isEmpty()){
            reverse.pop();
        }
        while(!positive.isEmpty()){
            reverse.push(positive.peek());
            temp.push(positive.pop());
        }
        while(!temp.isEmpty()){
            positive.push(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        reverse.pop();
        while(!positive.isEmpty()){
            positive.pop();
        }
        while(!reverse.isEmpty()){
            positive.push(reverse.peek());
            temp.push(reverse.pop());
        }
        while(!temp.isEmpty()){
            reverse.push(temp.pop());
        }
    }

    // Get the front element.
    public int peek() {
        return reverse.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return reverse.isEmpty();
    }
}