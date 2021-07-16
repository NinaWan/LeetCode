class ExamRoom {
    private Map<Integer, int[]> startMap;
    private Map<Integer, int[]> endMap;
    private TreeSet<int[]> intervals;// intervals order by length ascending
    private int n;

    public ExamRoom(int n) {
        this.n = n;
        this.startMap = new HashMap();
        this.endMap = new HashMap();
        intervals = new TreeSet<int[]>((a, b) -> {
            int distanceA = distance(a);
            int distanceB = distance(b);
            if (distanceA == distanceB) {
                return b[0] - a[0];
            }
            return distanceA - distanceB;
        });

        addInterval(new int[] {-1, n});
    }

    public int seat() {
        int[] longest = intervals.last();
        int x = longest[0], y = longest[1];
        int seat = 0;

        if (x == -1) {
            seat = 0;
        } else if (y == n) {
            seat = n - 1;
        } else {
            seat = x + (y - x) / 2;
        }

        int[] left = new int[] {x, seat};
        int[] right = new int[] {seat, y};

        removeInterval(longest);
        addInterval(left);
        addInterval(right);

        return seat;
    }

    public void leave(int p) {
        int[] left = endMap.get(p);
        int[] right = startMap.get(p);
        int[] merged = new int[] {left[0], right[1]};

        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }

    private int distance(int[] interval) {
        int x = interval[0], y = interval[1];
        if (x == -1) {
            return y;
        }

        if (y == n) {
            return n - 1 - x;
        }

        return (y - x) / 2;
    }

    private void addInterval(int[] interval) {
        intervals.add(interval);
        startMap.put(interval[0], interval);
        endMap.put(interval[1], interval);
    }

    private void removeInterval(int[] interval) {
        intervals.remove(interval);
        startMap.remove(interval[0]);
        endMap.remove(interval[1]);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */