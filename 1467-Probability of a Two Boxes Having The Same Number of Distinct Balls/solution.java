class Solution {
    public double getProbability(int[] balls) {
        int n = Arrays.stream(balls).sum() / 2;
        double total = 0.0;// c(n, 2n), c(m,n)=p(m,n)/n!
        double valid = 0.0;

        // precalculate factorial
        double[] factorial = new double[49];
        factorial[0] = 1;
        for (int i = 1; i < 49; i++) {
            factorial[i] = i * factorial[i - 1];
        }

        // calculate total
        total = factorial[2 * n] / factorial[n] / factorial[n];

        // calculate valid
        valid = dfs(0, 0, 0, 0, balls, 0, factorial);

        return valid / total;
    }

    private double dfs(int dist1, int dist2, int count1, int count2, int[] balls, int p, double[] factorial) {
        if (p == balls.length) {
            return dist1 == dist2 && count1 == count2 ? 1
                                                      : 0;
        }

        double res = 0.0;
        // put all balls in 1st box
        res = dfs(dist1 + 1, dist2, count1 + balls[p], count2, balls, p + 1, factorial);
        // put all balls in 2nd box
        res += dfs(dist1, dist2 + 1, count1, count2 + balls[p], balls, p + 1, factorial);
        // part in 1st box and part in 2nd box
        for (int i = 1; i < balls[p]; i++) {
            // c(i, balls[p])
            res += (factorial[balls[p]] / factorial[i] / factorial[balls[p] - i]) *
                    dfs(dist1 + 1, dist2 + 1, count1 + i, count2 + balls[p] - i, balls, p + 1, factorial);
        }

        return res;
    }
}