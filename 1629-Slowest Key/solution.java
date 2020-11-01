class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] letters = keysPressed.toCharArray();
        char ans = letters[0];
        int max = releaseTimes[0];

        for (int i = 1; i < letters.length; i++) {
            int dur = releaseTimes[i] - releaseTimes[i - 1];
            if (max < dur) {
                max = dur;
                ans = letters[i];
            } else if (max == dur && letters[i] > ans) {
                ans = letters[i];
            }
        }

        return ans;
    }
}