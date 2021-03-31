class Solution {
    public int largestAltitude(int[] gain) {
        int ans = Math.max(0, gain[0]), curr = gain[0];

        for (int i = 1; i < gain.length; i++) {
            curr += gain[i];
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}