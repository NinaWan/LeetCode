class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1;
        int[] result = new int[A.length];

        for (int num : A) {
            if (num % 2 == 0) {
                result[even] = num;
                even += 2;
            } else {
                result[odd] = num;
                odd += 2;
            }
        }

        return result;
    }
}