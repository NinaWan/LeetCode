class Solution {
    public int maximumSwap(int num) {
        if (num < 12) {
            return num;
        }

        // convert num to digit list
        List<Integer> digits = new ArrayList();
        int remainder = num % 10;
        int quotient = num;
        while (quotient != 0 || remainder != 0) {
            digits.add(0, remainder);
            quotient = quotient / 10;
            remainder = quotient % 10;
        }

        // find the rising point
        int rPoint = 0;
        for (; rPoint < digits.size() - 1; rPoint++) {
            if (digits.get(rPoint) < digits.get(rPoint + 1)) {
                break;
            }
        }
        if (rPoint == digits.size() - 1) {
            return num;
        }

        // find the max num after rising point
        int maxIdx = rPoint + 1;
        for (int i = rPoint + 1; i < digits.size(); i++) {
            if (digits.get(maxIdx) <= digits.get(i)) {
                maxIdx = i;
            }
        }

        // find the first smaller digit
        for (int i = 0; i < maxIdx; i++) {
            if (digits.get(i) < digits.get(maxIdx)) {
                int temp = digits.get(i);
                digits.set(i, digits.get(maxIdx));
                digits.set(maxIdx, temp);
                break;
            }
        }

        // convert list back to num
        return Integer.parseInt(digits.stream().map(String::valueOf).collect(Collectors.joining()));
    }
}