class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> row1 = new ArrayList();
        List<Integer> row2 = new ArrayList();
        int colNum = colsum.length;

        for (int i = 0; i < colNum; i++) {
            int cSum = colsum[i];
            if (cSum == 0) {
                row1.add(0);
                row2.add(0);
                continue;
            }

            if (upper < 0 || lower < 0 || (upper == 0 && lower == 0)) {
                return result;
            }

            if (cSum == 2) {
                row1.add(1);
                row2.add(1);
                upper--;
                lower--;
                continue;
            }

            if (upper > lower) {
                row1.add(1);
                row2.add(0);
                upper--;
            } else {
                row1.add(0);
                row2.add(1);
                lower--;
            }
        }

        if (upper != 0 || lower != 0) {
            return result;
        }

        result.add(row1);
        result.add(row2);

        return result;
    }
}