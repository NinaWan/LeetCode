class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> opening = new Stack();
        Stack<Integer> star = new Stack();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                opening.push(i);
            } else if (c == '*') {
                star.push(i);
            } else if (star.isEmpty() && opening.isEmpty()) {
                return false;
            } else if (!opening.isEmpty()) {
                opening.pop();
            } else {
                star.pop();
            }
        }

        while (!opening.isEmpty() || !star.isEmpty()) {
            if (opening.isEmpty()) {
                return true;
            }

            if (star.isEmpty() || opening.pop() > star.pop()) {
                return false;
            }
        }

        return true;
    }
}