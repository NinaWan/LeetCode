class LFUCache {
    private int cap;
    private int minFreq;
    private HashMap<Integer, Integer> keyToValue;
    private HashMap<Integer, Integer> keyToFreq;
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKey;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.minFreq = 0;
        keyToValue = new HashMap();
        keyToFreq = new HashMap();
        freqToKey = new HashMap();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);

        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (cap == 0) {
            return;
        }

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFreq(key);
            return;
        }

        if (keyToValue.size() >= cap) {
            removeMinFreq();
        }

        keyToValue.put(key, value);

        keyToFreq.put(key, 1);
        minFreq = 1;

        freqToKey.putIfAbsent(1, new LinkedHashSet());
        freqToKey.get(1).add(key);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);

        keyToFreq.put(key, freq + 1);

        freqToKey.get(freq).remove(key);
        if (freqToKey.get(freq).isEmpty()) {
            freqToKey.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }

        freqToKey.putIfAbsent(freq + 1, new LinkedHashSet());
        freqToKey.get(freq + 1).add(key);
    }

    private void removeMinFreq() {
        LinkedHashSet<Integer> keys = freqToKey.get(minFreq);
        int deletedKey = keys.iterator().next();

        keys.remove(deletedKey);// remove first one
        if (keys.isEmpty()) {
            freqToKey.remove(minFreq);
        }

        keyToValue.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */