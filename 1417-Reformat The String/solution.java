class Solution {
    public String reformat(String s) {
        List<Character> digits = new ArrayList();
        List<Character> letters = new ArrayList();

        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                digits.add(c);
            } else {
                letters.add(c);
            }
        }

        if (Math.abs(digits.size() - letters.size()) > 1) {
            return "";
        }

        String result = "";
        int l = Math.min(digits.size(), letters.size());

        for (int i = 0; i < l; i++) {
            result += digits.get(i).toString() + letters.get(i).toString();
        }

        if (digits.size() > l) {
            result += digits.get(l).toString();
        } else if (letters.size() > l) {
            result = letters.get(l).toString() + result;
        }

        return result;
    }
}