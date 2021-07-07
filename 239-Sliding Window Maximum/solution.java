class Solution {
    public class MonotonicQueue {
        LinkedList<Integer> queue = new LinkedList();

        public void push(int n) {
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.pollLast();
            }

            queue.addLast(n);
        }

        public int max() {
            return queue.getFirst();
        }

        public void pop(int n) {
            if (queue.getFirst() == n) {
                queue.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        MonotonicQueue window = new MonotonicQueue();

        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                ans[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }

        return ans;
    }
}