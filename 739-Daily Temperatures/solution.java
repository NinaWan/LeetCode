class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] last = new int[101];
        Arrays.fill(last, -1);

        for (int i = T.length - 1; i >= 0; i--) {
            int index = Integer.MAX_VALUE;
            for (int temp = T[i] + 1; temp <= 100; temp++) {
                if (last[temp] != -1) {
                    index = Math.min(index, last[temp]);
                }
            }

            if (index < T.length) {
                ans[i] = index - i;
            }

            last[T[i]] = i;
        }

        return ans;
    }
}