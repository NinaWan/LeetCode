class Solution {
    public int getWinner(int[] arr, int k) {
        Queue<Integer> queue = new LinkedList();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            queue.offer(arr[i]);
            max = Math.max(max, arr[i]);
        }

        if (k >= arr.length) {
            return Math.max(max, arr[0]);
        }

        int curr = arr[0];
        int counter = 0;

        while (!queue.isEmpty()) {
            if (curr > queue.peek()) {
                queue.offer(queue.poll());
                counter++;
            } else {
                queue.offer(curr);
                curr = queue.poll();
                counter = 1;
            }

            if (counter == k) {
                return curr;
            }
        }

        return curr;
    }
}