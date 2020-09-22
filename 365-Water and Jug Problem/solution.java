class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || z == x || z == y) {
            return true;
        }

        if (x + y < z) {
            return false;
        }

        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}