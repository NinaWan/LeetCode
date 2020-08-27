class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] freq = new int[n];
        List<Integer> result = new ArrayList();
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < rounds.length; i++) {
            int start = rounds[i - 1];
            int end = rounds[i];
            int curr = start;

            while (curr != end) {
                freq[curr - 1]++;
                max = Math.max(max, freq[curr - 1]);
                curr++;
                if (curr > n) {
                    curr -= n;
                }
            }

            if (i == rounds.length - 1) {
                freq[end - 1]++;
            }

            max = Math.max(max, freq[end - 1]);
        }

        for (int i = 0; i < n; i++) {
            if (freq[i] == max) {
                result.add(i + 1);
            }
        }

        return result;
    }
}