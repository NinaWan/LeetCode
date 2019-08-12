public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList();
        int i = digits.length - 1;
        while (i > -1 && digits[i] == 9) {
            result.add(0);
            if (i == 0) {
                result.add(1);
            }
            i--;
        }

        for (int k = i; k > -1; k--) {
            if (k == i) {
                result.add(digits[k] + 1);
            } else {
                result.add(digits[k]);
            }
        }

        int[] resultArray = new int[result.size()];

        for (int j = 0; j < result.size(); j++) {
            resultArray[j] = result.get(result.size() - j - 1);
        }

        return resultArray;
    }
}