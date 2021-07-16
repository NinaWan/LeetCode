class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
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
            if (map.containsKey(c) && (stack.isEmpty() || !map.get(c).equals(stack.pop()))) {
                return false;
            } else if (!map.containsKey(c)) {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}