class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0;
        int[] freq = new int[1000];

        for (int answer : answers) {
            freq[answer]++;
        }

        for (int i = 0; i < 1000; i++) {
            if (freq[i] == 0) {
                continue;
            }

            if (freq[i] <= i) {
                ans += i + 1;
            }

            if (freq[i] > i) {
                ans += freq[i] % (1 + i) == 0 ? freq[i] : freq[i] - freq[i] % (1 + i) + 1 + i;
            }
        }

        return ans;
    }
}