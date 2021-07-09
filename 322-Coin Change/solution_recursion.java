class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount + 1]);
    }

    private int coinChange(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != 0) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin, memo);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }

        memo[amount] = res == Integer.MAX_VALUE ? -1
                                                : res;
        return memo[amount];
    }
}