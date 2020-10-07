class Solution {
    public String reorderSpaces(String text) {
        String ans = "";
        List<String> words = new ArrayList();
        String word = "";
        int count = 0;

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                count++;
                if (word.length() != 0) {
                    words.add(word);
                }
                word = "";
            } else {
                word += String.valueOf(c);
            }
        }

        if (word.length() != 0) {
            words.add(word);
        }

        if (words.size() == 1) {
            for (int i = 0; i < count; i++) {
                ans += " ";
            }
            return words.get(0) + ans;
        }

        int n = count / (words.size() - 1);
        String s = "";
        for (int i = 0; i < n; i++) {
            s += " ";
        }

        for (int i = 0; i < words.size(); i++) {
            ans += words.get(i);
            if (i != words.size() - 1) {
                ans += s;
            }
        }

        for (int i = 0; i < count % (words.size() - 1); i++) {
            ans += " ";
        }

        return ans;
    }
}