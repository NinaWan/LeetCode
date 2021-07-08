class Solution {
    private Random random;
    private Map<Integer, Integer> map;
    private int M;

    public Solution(int N,
                    int[] blacklist) {
        this.random = new Random();
        this.map = new HashMap();

        for (int b : blacklist) {
            map.put(b, -1);
        }

        M = N - blacklist.length;
        int last = N - 1;
        for (int b : blacklist) {
            if (b < M) {
                while (map.containsKey(last)) {
                    last--;
                }
                map.put(b, last);
                last--;
            }
        }
    }

    public int pick() {
        int r = random.nextInt(M);

        return map.getOrDefault(r, r);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */