class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, List<Integer>> posm = new TreeMap(Collections.reverseOrder());

        Arrays.sort(A);
        for (int i = 0; i < B.length; i++) {
            List<Integer> posl = posm.getOrDefault(B[i], new ArrayList());
            posl.add(i);
            posm.put(B[i], posl);
        }

        int al = 0;
        int ar = A.length - 1;
        for (Map.Entry<Integer, List<Integer>> entry : posm.entrySet()) {
            int num = entry.getKey();
            List<Integer> indexes = entry.getValue();
            for (int index : indexes) {
                if (A[ar] > num) {
                    result[index] = A[ar];
                    ar--;
                } else {
                    result[index] = A[al];
                    al++;
                }
            }
        }

        return result;
    }
}