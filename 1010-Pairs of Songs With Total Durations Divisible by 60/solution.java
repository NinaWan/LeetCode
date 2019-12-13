class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        for (int i = 0; i < time.length; i++) {
            count[time[i] % 60]++;
        }

        int result = (count[0] * (count[0] - 1) + count[30] * (count[30] - 1)) / 2;
        for (int i = 1; i < 30; i++) {
            result += count[i] * count[60 - i];
        }

        return result;
    }
}