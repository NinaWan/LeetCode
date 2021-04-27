class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int lower = 0, upper = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = nums.size();
        int[] next = new int[n]; // next index for each list of nums list
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));// indexes of next
                                                                                                                                 // array

        for (int i = 0; i < n; i++) {
            queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }

        while (queue.size() == n) {
            int k = queue.poll();
            int min = nums.get(k).get(next[k]);
            if (upper - lower > max - min) {
                lower = min;
                upper = max;
            }

            if (++next[k] == nums.get(k).size()) {
                break;
            }

            max = Math.max(max, nums.get(k).get(next[k]));
            queue.offer(k);
        }

        return new int[] {lower, upper};
    }
}