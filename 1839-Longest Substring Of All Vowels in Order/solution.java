class Solution {
    public int longestBeautifulSubstring(String word) {
        int ans = 0, n = word.length();

        for (int i = 0; i < n;) {
            if (word.charAt(i) != 'a') {
                i++;
                continue;
            }

            int length = 1, count = 1, j = i;
            while (j < n - 1 && word.charAt(j + 1) >= word.charAt(j)) {
                if (word.charAt(j + 1) > word.charAt(j)) {
                    count++;
                }
                length++;
                j++;
            }

            if (j == n - 1 && j - i + 1 < 5) {
                break;
            }

            if (count == 5) {
                ans = Math.max(ans, length);
            }

            i = j;
        }

        return ans;
    }
}