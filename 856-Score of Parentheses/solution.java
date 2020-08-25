class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0);

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int curr = stack.pop();
                int pre = stack.pop();

                stack.push(pre + Math.max(2 * curr, 1));
            }
        }

        return stack.pop();
    }
}