class FrontMiddleBackQueue {
    private Deque<Integer> left;
    private Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque();
        right = new ArrayDeque();
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        resize();
    }

    public void pushMiddle(int val) {
        left.offerLast(val);
        resize();
    }

    public void pushBack(int val) {
        right.offerLast(val);
        resize();
    }

    public int popFront() {
        int res = -1;

        if (!left.isEmpty()) {
            res = left.pollFirst();
        } else if (!right.isEmpty()) {
            res = right.pollFirst();
        }

        resize();

        return res;
    }

    public int popMiddle() {
        int res = -1;

        if (left.isEmpty() && right.isEmpty()) {
            res = -1;
        } else if (left.size() == right.size()) {
            res = left.pollLast();
        } else {
            res = right.pollFirst();
        }

        resize();

        return res;
    }

    public int popBack() {
        int res = -1;

        if (!right.isEmpty()) {
            res = right.pollLast();
        } else if (!left.isEmpty()) {
            res = left.pollLast();
        }

        resize();

        return res;
    }

    private void resize() {
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }

        if (right.size() - 1 > left.size()) {
            left.offerLast(right.pollFirst());
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */