class Solution {
    public int balancedString(String s) {
        if (s.length() < 4) {
            return -1;
        }

        int result = s.length();
        int[] freq = new int[4];// count for each letter outside range [i, j]

        for (char c : s.toCharArray()) {
            freq["QWER".indexOf(c)]++;
        }

        int l = 0;
        int r = 0;
        int th = s.length() / 4;
        for (; l < s.length(); l++) {
            for (; r < s.length() && (freq[0] > th || freq[1] > th || freq[2] > th || freq[3] > th); r++) {
                freq["QWER".indexOf(s.charAt(r))]--;
            }

            if (freq[0] <= th && freq[1] <= th && freq[2] <= th && freq[3] <= th) {
                result = Math.min(result, r - l);
            }

            freq["QWER".indexOf(s.charAt(l))]++;
        }

        return result;
    }
}