class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }

        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n == 1 ? true : false;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 && flowerbed[i + 1] == 0) || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) || (i != 0 && i != flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)) {
                    n--;
                    flowerbed[i] = 1;
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }

        return n == 0 ? true : false;
    }
}