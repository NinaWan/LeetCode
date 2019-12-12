class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList();

        Integer[] orderedIndexes = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            orderedIndexes[i] = i;
        }

        Arrays.sort(orderedIndexes, (index1, index2) -> A[index2] - A[index1]);//order by descending
        int disorderedCount = A.length;

        for (int index : orderedIndexes) {
            for (int flip : result) {
                if (index + 1 <= flip) {
                    index = flip - index - 1;
                }
            }

            result.add(index + 1);
            result.add(disorderedCount--);
        }

        return result;
    }
}