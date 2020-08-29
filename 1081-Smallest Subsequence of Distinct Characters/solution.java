class Solution {
    public String smallestSubsequence(String text) {
        String ans = "";
        Map<Character, Integer> last = new HashMap();
        Stack<Character> stack = new Stack();
        boolean[] added = new boolean[26];

        for (int i = 0; i < text.length(); i++) {
            last.put(text.charAt(i), i);
        }

        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);
            if (added[curr - 'a']) {
                continue;
            }

            while (!stack.isEmpty()) {
                char pre = stack.peek();
                if (curr < pre && last.get(pre) > i) {
                    stack.pop();
                    added[pre - 'a'] = false;
                } else {
                    break;
                }
            }

            stack.push(curr);
            added[curr - 'a'] = true;
        }

        while (!stack.isEmpty()) {
            ans = stack.pop().toString() + ans;
        }

        return ans;
    }
}