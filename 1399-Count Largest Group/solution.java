class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> freq = new HashMap();

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int quotient = i;
            while (quotient != 0) {
                sum += quotient % 10;
                quotient /= 10;
            }

            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        int result = 0;
        int max = Collections.max(freq.values());
        for (Integer s : freq.values()) {
            if (s == max) {
                result++;
            }
        }

        return result;
    }
}