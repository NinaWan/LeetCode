class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack();
        stack.push(new TreeMap());

        for (int i = 0; i < n;) {
            char c = formula.charAt(i);
            if (c == '(') {
                i++;
                stack.push(new TreeMap());
            } else if (c == ')') {
                Map<String, Integer> inside = stack.pop();
                int start = ++i, multiplier = 1;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (start < i) {
                    multiplier = Integer.valueOf(formula.substring(start, i));
                }
                Map<String, Integer> count = stack.peek();
                for (Map.Entry<String, Integer> entry : inside.entrySet()) {
                    String key = entry.getKey();
                    count.put(key, count.getOrDefault(key, 0) + entry.getValue() * multiplier);
                }
            } else {
                int start = i++, factor = 1;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String key = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (start < i) {
                    factor = Integer.valueOf(formula.substring(start, i));
                }
                Map<String, Integer> count = stack.peek();
                count.put(key, count.getOrDefault(key, 0) + factor);
            }
        }

        String ans = "";
        for (Map.Entry<String, Integer> entry : stack.peek().entrySet()) {
            ans += entry.getKey() + (entry.getValue() > 1 ? entry.getValue()
                                                          : "");
        }

        return ans;
    }
}