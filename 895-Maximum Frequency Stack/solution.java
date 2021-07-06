class FreqStack {
    private int maxFreq;
    private Map<Integer, Integer> valToFreq;
    private Map<Integer, Stack<Integer>> freqToVals;

    public FreqStack() {
        maxFreq = 0;
        valToFreq = new HashMap();
        freqToVals = new HashMap();
    }

    public void push(int val) {
        int f = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, f);
        maxFreq = Math.max(maxFreq, f);
        freqToVals.computeIfAbsent(f, x -> new Stack()).push(val);
    }

    public int pop() {
        int val = freqToVals.get(maxFreq).pop();
        if (freqToVals.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        valToFreq.put(val, valToFreq.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */