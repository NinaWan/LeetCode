class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap() {
            {
                put('}', '{');
                put(')', '(');
                put(']', '[');
            }
        };
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || !map.containsKey(c) || !map.get(c).equals(stack.peek())) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}