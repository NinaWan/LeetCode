class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                int right = stack.pop();
                int left = stack.pop();
                if (token.equals("+")) {
                    stack.push(left + right);
                } else if (token.equals("-")) {
                    stack.push(left - right);
                } else if (token.equals("*")) {
                    stack.push(left * right);
                } else {
                    stack.push(left / right);
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.peek();
    }
}