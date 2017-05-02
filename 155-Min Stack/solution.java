public class MinStack {

    private int min;
    private List<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new ArrayList<Integer>();
    }

    public void push(int x) {
        if(x < min){
            min = x;
        }
        stack.add(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.remove(stack.size()-1);
        }
        min = Integer.MAX_VALUE;
        // loop list to find min
        for(Integer current:stack){
            if(current < min){
                min = current;
            }
        }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */