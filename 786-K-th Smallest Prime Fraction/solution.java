class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]);
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {i, n - 1});
        }

        while (--k > 0) {
            int[] index = queue.poll();
            if (--index[1] >= 0) {
                queue.offer(index);
            }
        }

        return new int[] {arr[queue.peek()[0]], arr[queue.peek()[1]]};
    }
}