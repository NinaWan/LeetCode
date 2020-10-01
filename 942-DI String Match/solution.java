class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] ans = new int[N + 1];
        int min = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'D') {
                ans[i + 1] = min - 1;
                min--;
            } else {
                ans[i + 1] = max + 1;
                max++;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] -= min;
        }

        return ans;
    }
}