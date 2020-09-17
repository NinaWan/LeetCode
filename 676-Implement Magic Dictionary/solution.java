class MagicDictionary {
    Map<Integer, Set<String>> dict;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        this.dict = new HashMap();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Set<String> set = this.dict.getOrDefault(word.length(), new HashSet());
            set.add(word);
            this.dict.put(word.length(), set);
        }
    }

    public boolean search(String searchWord) {
        if (!this.dict.containsKey(searchWord.length())) {
            return false;
        }

        for (String word : this.dict.get(searchWord.length())) {
            int diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diff++;
                }

                if (diff > 1) {
                    break;
                }
            }

            if (diff == 1) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */