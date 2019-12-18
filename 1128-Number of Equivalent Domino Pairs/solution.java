class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int result = 0;
        Map<String, Integer> counts = new HashMap();

        for (int i = 0; i < dominoes.length; i++) {
            String key = (dominoes[i][0] + dominoes[i][1]) + "," + (Math.abs(dominoes[i][0] - dominoes[i][1]));
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }

        for (int count : counts.values()) {
            result += count * (count - 1) / 2;
        }

        return result;
    }
}