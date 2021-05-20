class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList();

        addOperators(num, 0, "", target, 0, 0, ans);

        return ans;
    }

    private void addOperators(String num, int start, String expr, int target, long eval, long multiplier, List<String> result) {
        if (start == num.length()) {
            if (eval == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0') {
                break;
            }
            long curr = Long.valueOf(num.substring(start, i + 1)); // [start, i)
            if (start == 0) {
                addOperators(num, i + 1, expr + curr, target, curr, curr, result);
            } else {
                addOperators(num, i + 1, expr + "+" + curr, target, eval + curr, curr, result);
                addOperators(num, i + 1, expr + "-" + curr, target, eval - curr, -curr, result);
                addOperators(num, i + 1, expr + "*" + curr, target, eval - multiplier + multiplier * curr, multiplier * curr, result);
            }
        }
    }
}