class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int own = Integer.MIN_VALUE, notOwn = 0, preNotOwn = 0;
        for (int i = 0; i < prices.length; i++) {
            int tmp = notOwn;
            notOwn = Math.max(notOwn, own + prices[i]);// rest or sell
            own = Math.max(own, preNotOwn - prices[i]);// rest or buy
            preNotOwn = tmp;
        }

        return Math.max(own, notOwn);
    }
}