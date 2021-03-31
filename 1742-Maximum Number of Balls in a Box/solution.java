class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap();
        for (int num = lowLimit; num <= highLimit; num++) {
            int sum = 0, quotient = num;
            while (quotient != 0) {
                sum += quotient % 10;
                quotient = quotient / 10;
            }
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }

        return ans;
    }
}