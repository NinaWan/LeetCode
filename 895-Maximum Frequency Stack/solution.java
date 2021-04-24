class FreqStack {
    private int maxFreq;
    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> group;

    public FreqStack() {
        maxFreq = 0;
        freq = new HashMap();
        group = new HashMap();
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);
        group.computeIfAbsent(f, x -> new Stack()).push(val);
    }

    public int pop() {
        int val = group.get(maxFreq).pop();
        if (group.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        freq.put(val, freq.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */