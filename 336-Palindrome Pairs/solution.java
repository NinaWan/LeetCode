class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList();
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        // case 1: empty + palindrome
        if (map.containsKey("")) {
            int i = map.get("");
            for (int j = 0; j < words.length; j++) {
                if (isPalindrome(words[j]) && i != j) {
                    ans.add(Arrays.asList(i, j));
                    ans.add(Arrays.asList(j, i));
                }
            }
        }

        // case 2: s1 + s2
        for (int i = 0; i < words.length; i++) {
            int j = map.getOrDefault(reverse(words[i]), -1);
            if (i != j && j != -1) {
                ans.add(Arrays.asList(i, j));
            }
        }

        // case 3: partial s1 + s2 or s1 + partial s2
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int k = 1; k < word.length(); k++) {
                String left = word.substring(0, k), right = word.substring(k);

                if (isPalindrome(right)) {
                    int j = map.getOrDefault(reverse(left), -1);
                    if (j != -1) {
                        ans.add(Arrays.asList(i, j));
                    }
                }

                if (isPalindrome(left)) {
                    int j = map.getOrDefault(reverse(right), -1);
                    if (j != -1) {
                        ans.add(Arrays.asList(j, i));
                    }
                }
            }
        }

        return ans;
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    private boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}