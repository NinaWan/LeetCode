class Solution {
    public int maxNumberOfBalloons(String text) {
        int result = Integer.MAX_VALUE;
        int[] freq = new int[5];

        for (char c : text.toCharArray()) {
            int p = "ablon".indexOf(c);
            if (p != -1) {
                freq[p]++;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (i == 2 || i == 3) {
                result = Math.min(result, freq[i] / 2);
            } else {
                result = Math.min(result, freq[i]);
            }
        }

        return result;
    }
}