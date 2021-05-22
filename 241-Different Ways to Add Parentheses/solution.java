class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                for (int left : leftList) {
                    for (int right : rightList) {
                        if (c == '+') {
                            ans.add(left + right);
                        } else if (c == '-') {
                            ans.add(left - right);
                        } else if (c == '*') {
                            ans.add(left * right);
                        }
                    }
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(expression));
        }

        return ans;
    }
}