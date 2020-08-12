class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Map<Integer, Integer> fullLakes = new HashMap();
        TreeSet<Integer> dryDays = new TreeSet();

        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];

            if (lake > 0) {
                ans[i] = -1;

                if (fullLakes.containsKey(lake)) {
                    Integer dryDay = dryDays.ceiling(fullLakes.get(lake));
                    if (dryDay == null) {
                        return new int[0];
                    } else {
                        ans[dryDay] = lake;
                        dryDays.remove(dryDay);
                    }
                }

                fullLakes.put(lake, i);
            } else {
                dryDays.add(i);
            }
        }

        for (Integer dryDay : dryDays) {
            ans[dryDay] = 1;
        }

        return ans;
    }
}