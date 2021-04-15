class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder()) {
            {
                add(a);
                add(b);
                add(c);
            }
        };

        int ans = 0;
        while (queue.size() > 1) {
            int max1 = queue.poll();
            int max2 = queue.poll();
            ans++;
            if (--max1 > 0) {
                queue.add(max1);
            }
            if (--max2 > 0) {
                queue.add(max2);
            }
        }

        return ans;
    }
}