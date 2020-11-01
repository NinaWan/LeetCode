class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int ans = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                ans += sign * num;
            } else if (c == '(') {
                stack.push(ans);
                ans = 0;
                stack.push(sign);
                sign = 1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == ')') {
                ans = stack.pop() * ans + stack.pop();
            }
        }

        return ans;
    }
}