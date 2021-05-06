class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ')') {
                Set<Character> set = new HashSet();
                while (stack.peek() != '(') {
                    set.add(stack.pop());
                }
                stack.pop();// pop out '('
                char op = stack.pop();
                if (op == '|') {
                    stack.push(set.contains('t') ? 't'
                                                 : 'f');
                } else if (op == '&') {
                    stack.push(set.contains('f') ? 'f'
                                                 : 't');
                } else {
                    stack.push(set.contains('t') ? 'f'
                                                 : 't');
                }
            } else if (c != ',') {
                stack.push(c);
            }
        }

        return stack.peek() == 't';
    }
}