class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet();

        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) {
                continue;
            }

            int j = i + 1;
            while (j < word.length() && Character.isDigit(word.charAt(j))) {
                j++;
            }

            String num = word.substring(i, j);
            int p = 0;
            while (p < num.length() - 1 && num.charAt(p) == '0') {// remove leading zeros
                p++;
            }
            set.add(num.substring(p));

            i = j;
        }

        return set.size();
    }
}