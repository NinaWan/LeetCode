class Solution {
    public int preimageSizeFZF(int K) {
        long low = 0, high = 5L * (K + 1);
        while (low < high) {
            long mid = low + (high - low) / 2;
            long k = numOfTrailingZeros(mid);
            if (k == K) {
                return 5;
            } else if (k > K) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0;
    }

    private long numOfTrailingZeros(long num) {
        long ans = 0;
        while (num > 0) {
            ans += num / 5;
            num /= 5;
        }

        return ans;
    }
}