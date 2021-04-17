class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int ans = 0;
        int t = minutesToTest / minutesToDie + 1;

        while (Math.pow(t, ans) < buckets) {
            ans++;
        }

        return ans;
    }
}