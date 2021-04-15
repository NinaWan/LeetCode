class Solution {
    public int countVowelStrings(int n) {
        return count(n, 1);
    }

    private int count(int n, int last) {
        if (n == 0) {
            return 1;
        }

        int ans = 0;
        for (int i = last; i <= 5; i++) {
            ans += count(n - 1, i);
        }

        return ans;
    }
}