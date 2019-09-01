class Solution {
    public int repeatedNTimes(int[] A) {
        int result = Integer.MIN_VALUE;
        Set<Integer> temp = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (temp.contains(Integer.valueOf(A[i]))) {
                result = A[i];
                break;
            } else {
                temp.add(Integer.valueOf(A[i]));
            }
        }

        return result;
    }
}