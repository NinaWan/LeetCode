class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }

        int own = Integer.MIN_VALUE, notOwn = 0;
        for (int i = 0; i < prices.length; i++) {
            notOwn = Math.max(notOwn, own + prices[i]);// rest or sell
            own = Math.max(own, notOwn - prices[i] - fee);// rest or buy
        }

        return Math.max(notOwn, own);
    }
}