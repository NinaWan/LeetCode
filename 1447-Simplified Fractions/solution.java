class Solution {
    public List<String> simplifiedFractions(int n) {
        Set<String> ans = new HashSet();

        for (int num = 1; num < n; num++) {
            for (int den = num + 1; den <= n; den++) {
                int gcd = gcd(num, den);
                ans.add(num / gcd + "/" + den / gcd);
            }
        }

        return new ArrayList(ans);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}