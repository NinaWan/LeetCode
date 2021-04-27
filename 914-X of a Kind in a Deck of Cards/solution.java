class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> counter = new HashMap();
        int X = 0;
        for (int num : deck) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        for (int count : counter.values()) {
            X = greatestCommonDivisor(count, X);
        }

        return X > 1;
    }

    private int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a
                      : greatestCommonDivisor(b, a % b);
    }
}