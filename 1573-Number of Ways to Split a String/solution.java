class Solution {
    public int numWays(String s) {
        long count = 0;
        long n = s.length();
        Map<Long, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                map.put(count, i + 1);
            }
        }

        if (count == 0) {
            return (int) (((n - 1) * (n - 2) / 2) % (1e9 + 7));
        }

        if (count % 3 != 0) {
            return 0;
        }

        return (int) (((long) (map.get(count / 3 + 1) - map.get(count / 3)) * (map.get(count * 2 / 3 + 1) - map.get(count * 2 / 3))) % (1e9 + 7));
    }
}