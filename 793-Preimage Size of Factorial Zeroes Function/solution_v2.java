class Solution {
    public int preimageSizeFZF(int k) {
        return (int) (rightBound(k) - leftBound(k) + 1);
    }

    private long leftBound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long zeros = trailingZeroes(mid);
            if (zeros >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private long rightBound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long zeros = trailingZeroes(mid);
            if (zeros > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }

    private long trailingZeroes(long n) {
        long res = 0;

        for (long d = n; d / 5 > 0; d /= 5) {
            res += d / 5;
        }

        return res;
    }
}