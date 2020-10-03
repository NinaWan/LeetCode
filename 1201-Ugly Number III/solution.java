class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int ans = 0;
        int left = 0, right = (int) 2e9;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (count(mid, a, b, c) >= n) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private long count(int num, int a, int b, int c) {
        return num / a + num / b + num / c - num / lcm(a, b) - num / lcm(b, c) - num / lcm(a, c) + num / lcm(a, lcm(b, c));
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}