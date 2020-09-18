class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        this.timeMap = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> map = timeMap.getOrDefault(key, new TreeMap());
        map.put(timestamp, value);
        this.timeMap.put(key, map);
    }

    public String get(String key, int timestamp) {
        Map.Entry<Integer, String> entry = timeMap.get(key).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */