class RangeModule {
    private TreeMap<Integer, Integer> intervals;

    public RangeModule() {
        intervals = new TreeMap();
    }

    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if (start == null && end == null) {
            intervals.put(left, right);
        } else if (start != null && intervals.get(start) >= left) {
            // if start is not null, then end must not be null, since end at least can be same with start
            intervals.put(start, Math.max(intervals.get(start), Math.max(right, intervals.get(end))));
        } else {
            intervals.put(left, Math.max(right, intervals.get(end)));
        }

        // remove keys among (left, right]
        intervals.keySet().removeAll(new HashSet(intervals.subMap(left, false, right, true).keySet()));
    }

    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        return start == null ? false
                             : intervals.get(start) >= right ? true
                                                             : false;
    }

    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        if (end != null && intervals.get(end) > right) {
            intervals.put(right, intervals.get(end));
        }

        if (start != null && intervals.get(start) > left) {
            intervals.put(start, left);
        }

        // remove keys among [left, right)
        intervals.keySet().removeAll(new HashSet(intervals.subMap(left, true, right, false).keySet()));
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */