class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        intervals = new TreeMap();
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> floor = intervals.floorEntry(val);
        Map.Entry<Integer, Integer> ceiling = intervals.ceilingEntry(val);
        if (floor != null && ceiling != null) {
            if (floor.getValue() + 1 == val && ceiling.getKey() - 1 == val) {
                intervals.remove(ceiling.getKey());
                intervals.put(floor.getKey(), ceiling.getValue());
            } else if (val == floor.getValue() + 1) {
                intervals.put(floor.getKey(), val);
            } else if (val == ceiling.getKey() - 1) {
                intervals.put(val, ceiling.getValue());
                intervals.remove(ceiling.getKey());
            } else if (val > floor.getValue() + 1 && val < ceiling.getKey() - 1) {
                intervals.put(val, val);
            }
        } else if (floor != null) {
            if (val == floor.getValue() + 1) {
                intervals.put(floor.getKey(), val);
            } else if (val > floor.getValue() + 1) {
                intervals.put(val, val);
            }
        } else if (ceiling != null) {
            if (val == ceiling.getKey() - 1) {
                intervals.put(val, ceiling.getValue());
                intervals.remove(ceiling.getKey());
            } else {
                intervals.put(val, val);
            }
        } else {
            intervals.put(val, val);
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue();
            i++;
        }

        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */