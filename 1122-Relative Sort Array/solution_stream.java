class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length < 2) {
            return arr1;
        }

        Map<Integer, Integer> pos = new HashMap();
        for (int i = 0; i < arr2.length; i++) {
            pos.put(arr2[i], i);
        }

        return IntStream.of(arr1).boxed().sorted((num1, num2) -> {
            Integer pos1 = pos.get(num1);
            Integer pos2 = pos.get(num2);
            if (pos1 == null && pos2 == null) {
                return num1 - num2;
            }
            if (pos1 == null) {
                return 1;
            }

            if (pos2 == null) {
                return -1;
            }

            return pos1 - pos2;
        }).mapToInt(num -> num).toArray();
    }
}