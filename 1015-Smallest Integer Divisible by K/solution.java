class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0) {
            return -1;
        }

        int ans = 1, N = 1, remainder = 0;
        Set<Integer> set = new HashSet();
        while (!set.contains(remainder)) {
            N = remainder * 10 + 1;
            set.add(remainder);
            remainder = N % K;

            if (remainder == 0) {
                return ans;
            }

            ans++;
        }

        return -1;
    }
}