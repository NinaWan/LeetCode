class Solution {
    public int evaluate(String expression) {
        return eval(expression, new HashMap());
    }

    private int eval(String expr, Map<String, Integer> scope) {
        if (expr.charAt(0) != '(') {
            if (Character.isDigit(expr.charAt(0)) || expr.charAt(0) == '-') { // integer
                return Integer.valueOf(expr);
            }

            return scope.get(expr);// variable
        }

        Map<String, Integer> newScope = new HashMap();
        newScope.putAll(scope);
        List<String> tokens = parse(expr.substring(expr.charAt(1) == 'm' ? 6
                                                                         : 5,
                expr.length() - 1));
        if (expr.charAt(1) == 'a') {// add
            return eval(tokens.get(0), newScope) + eval(tokens.get(1), newScope);
        } else if (expr.charAt(1) == 'm') {// mult
            return eval(tokens.get(0), newScope) * eval(tokens.get(1), newScope);
        } else {// let
            for (int i = 0; i < tokens.size() - 2; i += 2) {
                newScope.put(tokens.get(i), eval(tokens.get(i + 1), newScope));
            }
            return eval(tokens.get(tokens.size() - 1), newScope);
        }
    }

    private List<String> parse(String expr) {
        List<String> res = new ArrayList();
        String s = "";
        int count = 0;

        for (char c : expr.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            if (count == 0 && c == ' ') {
                res.add(s);
                s = "";
            } else {
                s += c;
            }
        }

        if (s.length() > 0) {
            res.add(s);
        }

        return res;
    }
}