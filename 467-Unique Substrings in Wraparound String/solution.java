class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];

        int maxLength = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                maxLength++;
            } else {
                maxLength = 1;
            }

            int idx = p.charAt(i) - 'a';
            count[idx] = Math.max(count[idx], maxLength);
        }

        int ans = 0;
        for (int c : count) {
            ans += c;
        }
        return ans;
    }
}