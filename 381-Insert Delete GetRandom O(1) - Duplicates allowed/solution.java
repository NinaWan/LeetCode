class RandomizedCollection {

    Map<Integer, Set<Integer>> map;
    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        this.map = new HashMap();
        this.list = new ArrayList();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);

        if (!map.containsKey(val)) {
            map.put(val, new HashSet());
        }

        map.get(val).add(list.size() - 1);

        return map.get(val).size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        int index = map.get(val).iterator().next();
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        list.set(index, lastVal);
        map.get(lastVal).remove(lastIndex);
        if (val != lastVal) {
            map.get(val).remove(index);
            map.get(lastVal).add(index);
        }
        list.remove(lastIndex);

        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        if (list.isEmpty()) {
            return -1;
        }

        return list.get((int) (Math.random() * list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */