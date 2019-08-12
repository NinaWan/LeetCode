public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        return isPerfectSquare(num, 0, num);
    }

    private boolean isPerfectSquare(int num, int low, int high) {
        if (low > high) return false;
        int mid = (high - low) / 2 + low;
        if (Math.pow(mid, 2) > num) return isPerfectSquare(num, low, mid - 1);
        if (Math.pow(mid, 2) < num) return isPerfectSquare(num, mid + 1, high);
        return true;
    }
}