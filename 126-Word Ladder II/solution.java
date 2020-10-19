class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        wordSet.remove(beginWord);
        Map<String, Set<String>> ancestors = new HashMap();
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);

        while (wordSet.contains(endWord)) {
            Set<String> nextWords = new HashSet();
            while (!queue.isEmpty()) {
                String ancestor = queue.poll();
                Set<String> children = getNextWords(ancestor, wordSet);
                for (String child : children) {
                    Set<String> set = ancestors.getOrDefault(child, new HashSet());
                    set.add(ancestor);
                    ancestors.put(child, set);
                }
                nextWords.addAll(children);
            }

            if (nextWords.isEmpty()) {
                break;
            }

            for (String nextWord : nextWords) {
                wordSet.remove(nextWord);
                queue.offer(nextWord);
            }
        }

        return getPathes(endWord, ancestors);
    }

    private Set<String> getNextWords(String word, Set<String> wordSet) {
        Set<String> nextWords = new HashSet();
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == curr) {
                    continue;
                }

                chars[i] = c;
                String next = String.valueOf(chars);
                if (wordSet.contains(next)) {
                    nextWords.add(next);
                }
            }
            chars[i] = curr;
        }

        return nextWords;
    }

    private List<List<String>> getPathes(String node, Map<String, Set<String>> ancestors) {
        if (!ancestors.containsKey(node)) {
            return new ArrayList();
        }

        List<List<String>> pathes = new ArrayList();
        getPathes(node, ancestors, new ArrayList(Arrays.asList(node)), pathes);
        return pathes;
    }

    private void getPathes(String node, Map<String, Set<String>> ancestors, List<String> path, List<List<String>> result) {
        if (!ancestors.containsKey(node)) {
            result.add(new ArrayList(path));
            return;
        }

        for (String ancestor : ancestors.get(node)) {
            path.add(0, ancestor);
            getPathes(ancestor, ancestors, path, result);
            path.remove(0);
        }
    }
}