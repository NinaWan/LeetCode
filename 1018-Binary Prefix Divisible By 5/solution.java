class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList();

        int curr = 0;
        for (int i = 0; i < A.length; i++) {
            curr = curr * 2 + A[i];
            if (curr % 5 == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
            curr = curr % 5;
        }

        return result;
    }
}