class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);// sort by startDay ascending

        int ans = 0, i = 0, n = events.length;
        PriorityQueue<Integer> queue = new PriorityQueue();// store endDay
        for (int day = 1; day <= (int) 1e5; day++) {// for each start day
            while (!queue.isEmpty() && queue.peek() < day) {// remove closed events
                queue.poll();
            }
            while (i < n && events[i][0] == day) {// add events start on day
                queue.offer(events[i++][1]);
            }
            if (!queue.isEmpty()) {// attend the open event which will end soon
                queue.poll();
                ans++;
            }
        }

        return ans;
    }
}