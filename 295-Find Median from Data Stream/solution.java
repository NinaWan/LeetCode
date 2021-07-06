class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue();
        large = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */