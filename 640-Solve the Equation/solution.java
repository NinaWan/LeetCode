class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = simplify(parts[0]);
        int[] right = simplify(parts[1]);

        if (right[1] - left[1] == 0 && left[0] - right[0] == 0) {
            return "Infinite solutions";
        }

        if (left[0] - right[0] == 0) {
            return "No solution";
        }

        return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
    }

    private int[] simplify(String expression) {
        int[] ans = new int[2];

        List<Character> signs = new ArrayList();
        char first = expression.charAt(0);
        if (first == '+' || first == '-') {
            signs.add(first);
            expression = expression.substring(1, expression.length());
        } else {
            signs.add('+');
        }

        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-') {
                signs.add(c);
            }
        }

        String[] factors = expression.split("\\+|-");
        for (int i = 0; i < factors.length; i++) {
            String factor = factors[i];
            int num = 0;
            if (factor.charAt(factor.length() - 1) == 'x') {
                num = factor.equals("x") ? 1 : Integer.valueOf(factor.substring(0, factor.length() - 1));
                ans[0] += signs.get(i) == '+' ? num : -num;
            } else {
                num = Integer.valueOf(factor);
                ans[1] += signs.get(i) == '+' ? num : -num;
            }
        }

        return ans;
    }
}