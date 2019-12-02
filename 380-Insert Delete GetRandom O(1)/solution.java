class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.map = new HashMap();
        this.list = new ArrayList();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val) && map.get(val) != -1) {
            return false;
        } else {
            list.add(val);
            map.put(val, list.size() - 1);
        }

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val) && map.get(val) != -1) {
            int lastIndex = list.size() - 1;
            int lastVal = list.get(lastIndex);
            int index = map.get(val);

            list.set(index, lastVal);
            map.put(lastVal, index);
            map.put(val, -1);

            list.remove(lastIndex);

            return true;
        }

        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */