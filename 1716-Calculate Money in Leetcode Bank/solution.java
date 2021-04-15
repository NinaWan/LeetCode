class Solution {
    public int totalMoney(int n) {
        int day = n % 7, week = n / 7;
        return 28 * week + 7 * week * (week - 1) / 2 + week * day + day * (day + 1) / 2;
    }
}