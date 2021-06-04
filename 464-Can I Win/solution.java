class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }

        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }

        return canIWin(desiredTotal, new boolean[maxChoosableInteger + 1], new HashMap<String, Boolean>());
    }

    private boolean canIWin(int desiredTotal, boolean[] chosen, Map<String, Boolean> map) {
        if (desiredTotal <= 0) {
            return false;
        }

        String key = toString(chosen) + "," + desiredTotal;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        for (int i = 1; i < chosen.length; i++) {
            if (chosen[i] == true) {
                continue;
            }

            chosen[i] = true;
            if (!canIWin(desiredTotal - i, chosen, map)) {
                map.put(key, true);
                chosen[i] = false;
                return true;
            }
            chosen[i] = false;
        }
        map.put(key, false);

        return false;
    }

    private String toString(boolean[] chosen) {
        int num = 0;
        for (boolean b : chosen) {
            num <<= 1;
            if (b) {
                num |= 1;
            }
        }
        return String.valueOf(num);
    }
}