class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = Integer.MAX_VALUE;
        int rowNum = triangle.size();
        int[] current = new int[rowNum];
        int[] pre = new int[rowNum];

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == 0 && j == 0) {
                    pre[0] = triangle.get(i).get(j);
                    current[0] = pre[0];
                    continue;
                }

                if (j == 0) {
                    current[j] = triangle.get(i).get(j) + pre[j];
                    continue;
                }

                if (j == triangle.get(i).size() - 1) {
                    current[j] = triangle.get(i).get(j) + pre[j - 1];
                } else {
                    current[j] = triangle.get(i).get(j) + Math.min(pre[j], pre[j - 1]);
                }
            }

            for (int n = 0; n < rowNum; n++) {
                pre[n] = current[n];
            }
        }

        for (int m = 0; m < current.length; m++) {
            if (result > current[m]) {
                result = current[m];
            }
        }

        return result;
    }
}