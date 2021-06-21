class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int own = Integer.MIN_VALUE, notOwn = 0;
        for (int i = 0; i < prices.length; i++) {
            notOwn = Math.max(notOwn, own + prices[i]);// rest or sell
            own = Math.max(own, notOwn - prices[i]);// rest or buy
        }

        return Math.max(own, notOwn);
    }
}