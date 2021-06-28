class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();

        for (int i = 0, j = 0; i < firstList.length && j < secondList.length;) {
            int[] first = firstList[i], second = secondList[j];
            if (first[1] < second[0]) {
                i++;
            } else if (first[0] > second[1]) {
                j++;
            } else {
                ans.add(new int[] {Math.max(first[0], second[0]), Math.min(first[1], second[1])});
                if (first[1] <= second[1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}