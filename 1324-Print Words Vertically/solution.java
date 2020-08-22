class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        if (words.length < 2) {
            return Arrays.asList(s);
        }

        List<String> result = new ArrayList();
        int max = 0;
        for (String word : words) {
            max = Math.max(max, word.length());
        }

        for (int i = 0; i < max; i++) {
            String curr = "";
            for (String word : words) {
                if (i < word.length()) {
                    curr += (Character) word.charAt(i);
                } else {
                    curr += " ";
                }
            }
            result.add(trimTailingSpace(curr));
        }


        return result;
    }

    private String trimTailingSpace(String s) {
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }

        return s.substring(0, i + 1);
    }
}