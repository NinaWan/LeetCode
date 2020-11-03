class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        int carryOver = 1;
        List<Integer> result = new ArrayList();

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carryOver;
            carryOver = sum / 10;
            result.add(0, sum % 10);
        }

        if (carryOver != 0) {
            result.add(0, carryOver);
        }

        int[] resA = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resA[i] = result.get(i);
        }

        return resA;
    }
}