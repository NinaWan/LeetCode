class Solution {
    public String removeDuplicateLetters(String s) {
        String ans = "";
        Stack<Character> stack = new Stack();
        Set<Character> seen = new HashSet();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;

            if (seen.contains(c)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                seen.remove(stack.pop());
            }

            stack.push(c);
            seen.add(c);
        }

        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }
}