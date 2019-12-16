class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList();

        int minDigitNum = String.valueOf(low).toCharArray().length;
        int maxDigitNum = String.valueOf(high).toCharArray().length;

        for (int digitNum = minDigitNum; digitNum <= maxDigitNum; digitNum++) {
            for (int startNum = 1; startNum < 10; startNum++) {
                int num = getSequentialNum(digitNum, startNum);

                if (num >= low && num <= high) {
                    result.add(num);
                }

                if (num > high) {
                    return result;
                }
            }
        }

        return result;
    }

    private int getSequentialNum(int digitNum, int startNum) {
        if (startNum + digitNum > 10) {
            return -1;
        }

        int result = startNum;
        for (int i = 1; i < digitNum; i++) {
            result = result * 10 + startNum + i;
        }

        return result;
    }
}