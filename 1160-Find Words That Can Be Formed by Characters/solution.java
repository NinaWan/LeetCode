class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        int[] charCount = new int[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (String word : words) {
            int[] letterCount = new int[26];
            for (char c : word.toCharArray()) {
                letterCount[c - 'a']++;
            }

            boolean isGood = true;
            for (int i = 0; i < 26; i++) {
                if (letterCount[i] > charCount[i]) {
                    isGood = false;
                    break;
                }
            }

            if (isGood) {
                result += word.length();
            }
        }

        return result;
    }
}