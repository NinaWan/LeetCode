class Solution {
    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        int n = S.length();

        for (String word : words) {
            int m = word.length();

            if (m > n || (m == 0 && n != 0) || (m == n && !word.equals(S))) {
                continue;
            }

            if (m == n && word.equals(S)) {
                ans++;
                continue;
            }

            for (int i = 0, j = 0; i < n;) {
                char c = S.charAt(i);
                int target = 0;
                int source = 0;
                while (i < n && S.charAt(i) == c) {
                    i++;
                    target++;
                }

                while (j < m && word.charAt(j) == c) {
                    j++;
                    source++;
                }

                if (source == 0 || (target == 2 && source == 1) || (source > target)) {
                    break;
                }

                if (i == n && j == m) {
                    ans++;
                }
            }
        }

        return ans;
    }
}