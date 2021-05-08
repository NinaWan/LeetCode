class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
        int m = words1.length, n = words2.length, i = 0;

        if (m > n) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        while (i < m && words1[i].equals(words2[i])) {
            i++;
        }

        while (i < m && words1[i].equals(words2[n - m + i])) {
            i++;
        }

        return i == m;
    }
}