class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int result = 0;
        int[] diffs = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            diffs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        for (; right < diffs.length; ) {
            sum += diffs[right];
            if (sum > maxCost) {
                result = Math.max(result, right - left);
                sum -= diffs[right];

                sum -= left == right ? 0 : diffs[left];
                right += left == right ? 1 : 0;

                left++;
            } else {
                right++;
            }
        }

        return Math.max(result, right - left);
    }
}