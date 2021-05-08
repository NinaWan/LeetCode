class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26], last = new int[26];
        int ans = -1;
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] != -1) {
                ans = Math.max(ans, last[i] - first[i] - 1);
            }
        }

        return ans;
    }
}