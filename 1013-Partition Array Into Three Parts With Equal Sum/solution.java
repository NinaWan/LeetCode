class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int p = 0;
        int subSum = 0;
        for (int i = 0; i < A.length; i++) {
            subSum += A[i];
            if (subSum == sum / 3) {
                p++;
                subSum = 0;
            }
            if (p == 2) {
                i++;
                while (i < A.length) {
                    subSum += A[i];
                    i++;
                }

                return subSum == sum / 3 ? true : false;
            }
        }

        return false;
    }
}