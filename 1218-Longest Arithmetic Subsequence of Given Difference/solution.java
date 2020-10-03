class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> lsq = new HashMap();

        for (int num : arr) {
            lsq.put(num, lsq.getOrDefault(num - difference, 0) + 1);
            ans = Math.max(ans, lsq.get(num));
        }

        return ans;
    }
}