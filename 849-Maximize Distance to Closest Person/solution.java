class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int left = -1;

        for (int i = 0; i < seats.length; i++) {
            if (i == seats.length - 1 && seats[i] != 1) {
                ans = Math.max(ans, i - left);
            } else if (seats[i] == 1) {
                if (left == -1) {
                    ans = Math.max(ans, i);
                } else {
                    ans = Math.max(ans, (i - left) / 2);
                }
                left = i;
            }
        }

        return ans;
    }
}