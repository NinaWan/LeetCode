class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length, ans = Integer.MAX_VALUE;
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
        }

        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < n + 1; i++) {
            while (deque.size() > 0 && preSum[i] - preSum[deque.getFirst()] >= K) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while (deque.size() > 0 && preSum[i] <= preSum[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        return ans <= n ? ans
                        : -1;
    }
}