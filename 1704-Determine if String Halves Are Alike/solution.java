class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int count1 = 0, count2 = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < s.length() / 2 && vowels.contains(c)) {
                count1++;
            } else if (i >= s.length() / 2 && vowels.contains(c)) {
                count2++;
            }
        }

        return count1 == count2;
    }
}