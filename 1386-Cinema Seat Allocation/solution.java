class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int result = 0;
        Map<Integer, Set<Integer>> reservedMap = new HashMap();
        for (int i = 0; i < reservedSeats.length; i++) {
            Set<Integer> cols = reservedMap.getOrDefault(reservedSeats[i][0], new HashSet());
            cols.add(reservedSeats[i][1]);
            reservedMap.put(reservedSeats[i][0], cols);
        }

        result += 2 * (n - reservedMap.keySet().size());

        for (Set<Integer> cols : reservedMap.values()) {
            if (cols.size() > 6) {
                continue;
            }

            if (!cols.contains(4) && !cols.contains(5) && !cols.contains(6) && !cols.contains(7)) {
                if (!cols.contains(2) && !cols.contains(3) && !cols.contains(8) && !cols.contains(9)) {
                    result += 2;
                } else {
                    result += 1;
                }
            } else if ((!cols.contains(2) && !cols.contains(3) && !cols.contains(4) && !cols.contains(5)) || (!cols.contains(6) && !cols.contains(7) && !cols.contains(8) && !cols.contains(9))) {
                result += 1;
            }
        }

        return result;
    }
}