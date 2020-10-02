class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                k--;
                if (i * i != n) {
                    factors.add(n / i);
                }
            }

            if (k == 0) {
                return i;
            }
        }

        if (k > factors.size()) {
            return -1;
        }

        return factors.get(factors.size() - k);
    }
}