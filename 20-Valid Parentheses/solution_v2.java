class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != leftOf(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private char leftOf(char c) {
        if (c == ')') {
            return '(';
        }

        if (c == '}') {
            return '{';
        }

        return '[';
    }
}