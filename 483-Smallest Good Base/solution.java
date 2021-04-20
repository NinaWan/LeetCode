class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        int max = (int) (Math.log(num + 1) / Math.log(2));// log(n+1,2)

        for (int m = max; m > 2; m--) {
            long low = (long) Math.pow(num + 1, 1.0 / m);
            long high = (long) Math.pow(num, 1.0 / (m - 1));

            while (low <= high) {
                long k = low + (high - low) / 2;
                long x = 0L;
                for (int i = 0; i < m; i++) {
                    x = x * k + 1;
                }

                if (x == num) {
                    return String.valueOf(k);
                } else if (x < num) {
                    low = k + 1;
                } else {
                    high = k - 1;
                }
            }
        }

        return String.valueOf(num - 1); // when m=2
    }
}