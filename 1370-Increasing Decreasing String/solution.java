class Solution {
    public String sortString(String s) {
        String result = "";
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        boolean isDone = false;
        int p = 0;
        while (!isDone) {
            isDone = true;

            // smallest to largest
            for (p = 0; p < 26; p++) {
                if (freq[p] != 0) {
                    result += (char) ('a' + p);
                    if (--freq[p] != 0) {
                        isDone = false;
                    }
                }
            }

            // largest to smallest
            for (p = 25; p >= 0; p--) {
                if (freq[p] != 0) {
                    result += (char) ('a' + p);
                    if (--freq[p] != 0) {
                        isDone = false;
                    }
                }
            }
        }

        return result;
    }
}