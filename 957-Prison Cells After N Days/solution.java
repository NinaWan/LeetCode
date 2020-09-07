class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap();
        List<String> list = new ArrayList();
        String s = "";
        for (int c : cells) {
            s += c;
        }
        map.put(s, 0);
        list.add(s);

        for (int d = 1; d <= N; d++) {
            char[] pre = s.toCharArray();
            s = "";
            for (int i = 0; i < 8; i++) {
                if (i == 0 || i == 7 || pre[i - 1] != pre[i + 1]) {
                    s += 0;
                } else {
                    s += 1;
                }
            }

            if (map.containsKey(s)) {
                s = list.get((N - d) % (d - map.get(s)) + map.get(s));
                break;
            } else {
                map.put(s, d);
                list.add(s);
            }
        }

        int[] ans = new int[8];
        for (int i = 0; i < 8; i++) {
            ans[i] = s.charAt(i) - '0';
        }

        return ans;
    }
}