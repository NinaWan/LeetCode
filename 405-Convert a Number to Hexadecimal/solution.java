public class Solution {
    public String toHex(int num) {
        if (0 == num)
            return "0";

        Long quotient = Math.abs(Long.valueOf(num));
        int remainder = 0;
        List<Integer> hexNums = new ArrayList();
        String result = "";

        while (quotient != 0) {
            remainder = (int) (quotient % 16);
            hexNums.add(remainder);
            quotient = quotient / 16;
        }

        // For negative integer
        if (num < 0) {
            for (int i = hexNums.size(); i < 8; i++) {
                hexNums.add(0);
            }

            // Ones-complement code
            for (int i = 0; i < hexNums.size(); i++) {
                hexNums.set(i, 15 - hexNums.get(i));
            }

            // Plus one
            for (int i = 0; i < hexNums.size(); i++) {
                if (hexNums.get(i) == 15) {
                    hexNums.set(i, 0);
                    continue;
                }
                if (hexNums.get(i) != 15) {
                    hexNums.set(i, hexNums.get(i) + 1);
                    break;
                }
            }
        }

        for (Integer hexNum : hexNums) {
            if (hexNum > -1 && hexNum < 10) {
                result = hexNum + result;
            } else {
                result = (char) (hexNum - 9 + 96) + result;
            }
        }

        return result;
    }
}