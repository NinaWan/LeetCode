class Solution {
    public int beautySum(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;
                ans += beauty(count);
            }
        }

        return ans;
    }

    private int beauty(int[] count) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int c : count) {
            min = c == 0 ? min
                         : Math.min(min, c);
            max = Math.max(max, c);
        }

        return max - min;
    }
}