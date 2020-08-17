class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (i == s.length() - 1 || s.charAt(i + 1) == '(') {// single closing ')'
                result++;
            }

            if (stack.isEmpty()) {
                result++;
            } else {
                stack.pop();
            }

            if (i != s.length() - 1 && s.charAt(i + 1) == ')') {
                i++;
            }
        }

        return result + 2 * stack.size();
    }
}