class Solution {
    public int minIncrementForUnique(int[] A) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> counter = new TreeMap();

        for (int num : A) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int addition = 0;
        for (int i = min;; i++) {
            int count = counter.getOrDefault(i, 0) + addition;

            addition = count > 1 ? count - 1
                                 : 0;
            result += addition;

            if (i > max && addition == 0) {
                break;
            }
        }

        return result;
    }
}