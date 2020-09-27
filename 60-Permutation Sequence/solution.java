class Solution {
    public String getPermutation(int n, int k) {
        int p = 1;
        List<Integer> factors = new ArrayList();
        for (int i = 1; i <= n; i++) {
            p *= i;
            factors.add(i);
        }

        String ans = "";
        k -= 1;
        for (int i = n; i > 0; i--) {
            p /= i;
            int index = k / p;
            ans += factors.get(index);
            factors.remove(index);
            k %= p;
        }

        return ans;
    }
}