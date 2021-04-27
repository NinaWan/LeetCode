public class Solution {
    public String reverseVowels(String s) {
        if (null == s || s.isEmpty())
            return s;

        String vowels = "AEIOUaeiou";
        char[] letters = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (!vowels.contains(String.valueOf(letters[i])) && i < j)
                i++;
            while (!vowels.contains(String.valueOf(letters[j])) && i < j)
                j--;
            // Swap
            if (i < j) {
                char temp = letters[i];
                letters[i] = letters[j];
                letters[j] = temp;
            }
        }

        return String.valueOf(letters);
    }
}