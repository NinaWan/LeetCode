class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n < 1) {
            return true;
        }

        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }

        if (flowerbed.length == 1) {
            return n == 1 && flowerbed[0] == 0 ? true : false;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                return true;
            }

            if (flowerbed[i] == 1) {
                continue;
            }

            int left = i == 0 ? 0 : flowerbed[i - 1];
            int right = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];

            if (flowerbed[i] == 0 && left == 0 && right == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }

        return n == 0 ? true : false;
    }
}