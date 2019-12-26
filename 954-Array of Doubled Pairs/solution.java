class Solution {
    public boolean canReorderDoubled(int[] A) {
        int zeroCount = 0, negCount = 0, posCount = 0;
        Map<Integer, Integer> negCounts = new TreeMap();
        Map<Integer, Integer> posCounts = new TreeMap();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeroCount++;
                continue;
            }

            if (A[i] > 0) {
                posCount++;
                posCounts.put(A[i], posCounts.getOrDefault(A[i], 0) + 1);
            } else {
                negCount++;
                negCounts.put(A[i], negCounts.getOrDefault(A[i], 0) + 1);
            }
        }

        if (zeroCount % 2 != 0 || posCount % 2 != 0 || negCount % 2 != 0) {
            return false;
        }

        for (Map.Entry<Integer, Integer> entry : negCounts.entrySet()) {
            int key = entry.getKey() / 2;
            int countNeeded = Math.min(entry.getValue(), negCount / 2);
            if (entry.getValue() == 0) {
                continue;
            }

            if (countNeeded == 0) {
                break;
            }
            if (!negCounts.containsKey(key) || negCounts.get(key) < countNeeded) {
                return false;
            }
            negCounts.put(entry.getKey(), negCounts.get(entry.getKey()) - countNeeded);
            negCounts.put(key, negCounts.get(key) - countNeeded);
            negCount -= 2 * countNeeded;
        }

        for (Map.Entry<Integer, Integer> entry : posCounts.entrySet()) {
            int key = 2 * entry.getKey();
            int countNeeded = Math.min(entry.getValue(), posCount / 2);
            if (entry.getValue() == 0) {
                continue;
            }

            if (countNeeded == 0) {
                break;
            }
            if (!posCounts.containsKey(key) || posCounts.get(key) < countNeeded) {
                return false;
            }
            posCounts.put(entry.getKey(), posCounts.get(entry.getKey()) - countNeeded);
            posCounts.put(key, posCounts.get(key) - countNeeded);
            posCount -= 2 * countNeeded;
        }

        return true;
    }
}