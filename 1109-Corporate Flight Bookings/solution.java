class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int[] booking : bookings) {
            int first = booking[0], last = booking[1], seat = booking[2];
            ans[first - 1] += seat;
            if (last < n) {
                ans[last] -= seat;
            }
        }

        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }

        return ans;
    }
}