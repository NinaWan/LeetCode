class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        if (n == 0) {
            return tasks.length;
        }

        int[] remaining = new int[26];
        for (char task : tasks) {
            remaining[task - 'A']++;
        }

        int result = 0;
        Arrays.sort(remaining);

        while (remaining[25] > 0) {
            for (int i = 0; i <= n && remaining[25] > 0; i++) {
                if (i < 26) {
                    remaining[25 - i]--;
                }

                result++;

                if (remaining[25] == 0) {
                    break;
                }
            }

            Arrays.sort(remaining);
        }

        return result;
    }
}