class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[52];
        int need = 0;
        for (char c : t.toCharArray()) {
            int i = getIndex(c);
            if (freq[i] == 0) {
                need++;
            }
            freq[i]++;
        }

        int left = 0, right = 0, formed = 0;
        int[] window = new int[52];
        int[] ans = {-1, 0, 0};
        while (right < s.length()) {
            int i = getIndex(s.charAt(right));

            window[i]++;
            if (window[i] == freq[i]) {
                formed++;
            }

            while (formed == need && left <= right) {
                if (ans[0] == -1 || ans[0] > right - left + 1) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                int j = getIndex(s.charAt(left));
                window[j]--;
                if (window[j] < freq[j]) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? ""
                            : s.substring(ans[1], ans[2] + 1);
    }

    private int getIndex(char c) {
        if (c >= 'a') {
            return c - 'a' + 26;
        }

        return c - 'A';
    }
}