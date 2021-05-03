class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        int ans = 0;
        int n = tokens.length;
        Arrays.sort(tokens);

        for (int i = 0, j = n - 1, score = 0; i <= j && (score > 0 || P >= tokens[i]);) {
            while (i <= j && P >= tokens[i]) {
                P -= tokens[i++];
                score++;
            }

            ans = Math.max(ans, score);

            if (i <= j && score > 0) {
                P += tokens[j--];
                score--;
            }
        }

        return ans;
    }
}