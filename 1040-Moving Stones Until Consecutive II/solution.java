class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int[] result = new int[2];
        Arrays.sort(stones);

        // calculate max
        for (int i = 1; i < stones.length; i++) {
            result[1] += stones[i] - stones[i - 1] - 1;
        }
        result[1] -= Math.min(stones[1] - stones[0] - 1, stones[stones.length - 1] - stones[stones.length - 2] - 1);

        // calculate min
        int left = 0;
        int right = 0;
        result[0] = Integer.MAX_VALUE;
        while (right < stones.length) {
            while (stones[right] - stones[left] + 1 > stones.length) {
                left++;
            }

            int occupied = right - left + 1;
            if (occupied == stones.length - 1 && stones[right] - stones[left] + 1 == stones.length - 1) {
                result[0] = 2;
            } else {
                result[0] = Math.min(result[0], stones.length - occupied);
            }

            right++;
        }

        return result;
    }
}