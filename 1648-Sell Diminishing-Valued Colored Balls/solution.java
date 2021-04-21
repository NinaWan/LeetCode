class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int mod = (int) 1e9 + 7;
        long ans = 0L;
        int i = inventory.length - 1;

        Arrays.sort(inventory);

        while (orders > 0) {
            int count = inventory.length - i;
            if (i > 0 && inventory[i] > inventory[i - 1] && orders >= count * (inventory[i] - inventory[i - 1])) {
                ans += count * (S(inventory[i]) - S(inventory[i - 1]));
                orders -= count * (inventory[i] - inventory[i - 1]);
            } else if (i == 0 || inventory[i] > inventory[i - 1]) {
                long row = orders / count, left = orders % count;
                ans += count * (S(inventory[i]) - S(inventory[i] - row)) + left * (inventory[i] - row);
                orders = 0;
            }

            ans %= mod;
            i--;
        }

        return (int) ans;
    }

    private long S(long n) {
        return n * (n + 1) / 2;
    }
}