class MyCalendar {
    TreeMap<Integer, Integer> bookings;

    public MyCalendar() {
        this.bookings = new TreeMap();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> pre = bookings.floorEntry(start);
        Map.Entry<Integer, Integer> next = bookings.ceilingEntry(start);
        if (bookings.isEmpty() || (pre == null && end <= next.getKey()) || (next == null && start >= pre.getValue()) || (pre != null && next != null && start >= pre.getValue() && end <= next.getKey())) {
            bookings.put(start, end);
            return true;
        }

        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */