class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        }

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if (num1.equals("1") || num2.equals("1")) {
            return num1.equals("1") ? num2
                                    : num1;
        }

        String result = "";

        for (int i = 0; i < num1.length(); i++) {
            int carryOver = 0;
            int product = 1;
            String mulResult = "";

            for (int j = num2.length() - 1; j >= 0; j--) {// single Multiplication
                product = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)) + carryOver;
                mulResult = String.valueOf(product % 10) + mulResult;
                carryOver = product / 10;
            }

            if (carryOver != 0) {
                mulResult = String.valueOf(carryOver) + mulResult;
            }

            for (int m = 0; m < num1.length() - 1 - i; m++) {
                mulResult += "0";
            }

            carryOver = 0;
            int p1 = result.length() - 1;
            int p2 = mulResult.length() - 1;
            String sumResult = "";
            // single addition: result + mulResult
            while (p1 >= 0 || p2 >= 0) {
                int sum = carryOver;

                sum += p1 >= 0 ? Character.getNumericValue(result.charAt(p1))
                               : 0;
                sum += p2 >= 0 ? Character.getNumericValue(mulResult.charAt(p2))
                               : 0;

                sumResult = String.valueOf(sum % 10) + sumResult;
                carryOver = sum / 10;
                p1--;
                p2--;
            }

            if (carryOver != 0) {
                sumResult = String.valueOf(carryOver) + sumResult;
            }

            result = sumResult;
        }

        return result;
    }
}