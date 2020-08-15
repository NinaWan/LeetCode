class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        Map<Integer, List<Integer>> map = new TreeMap();

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                soldiers++;
            }

            List<Integer> list = map.getOrDefault(soldiers, new ArrayList());
            list.add(i);
            map.put(soldiers, list);
        }

        for (List<Integer> l : map.values()) {
            if (k == 0) {
                break;
            }

            for (int index : l) {
                if (k == 0) {
                    break;
                }
                result[result.length - k] = index;
                k--;
            }
        }

        return result;
    }
}