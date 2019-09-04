class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int result = 0;
        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < dominoes.length; i++) {
            int[] current = dominoes[i].clone();
            if (current[0] > current[1]) {
                int temp = current[0];
                current[0] = current[1];
                current[1] = temp;
            }

            String key = String.valueOf(current[0]) + String.valueOf(current[1]);
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }

        for (Map.Entry entry : counts.entrySet()) {
            int count = (Integer) entry.getValue();
            result += count * (count - 1) / 2;
        }

        return result;
    }
}