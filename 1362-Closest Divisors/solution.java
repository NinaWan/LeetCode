class Solution {
    public int[] closestDivisors(int num) {
        int[] diff1 = helper(num + 1);
        int[] diff2 = helper(num + 2);

        return Math.abs(diff1[0] - diff1[1]) > Math.abs(diff2[0] - diff2[1]) ? diff2
                                                                             : diff1;
    }

    private int[] helper(int num) {
        int[] ans = new int[] {1, num};

        for (int a = (int) Math.sqrt(num); a >= 1; a--) {
            int b = num / a;
            if (num % a == 0 && Math.abs(a - b) < Math.abs(ans[1] - ans[0])) {
                ans[0] = a;
                ans[1] = b;
            }
        }

        return ans;
    }
}