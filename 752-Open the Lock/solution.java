class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }

        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        queue.offer("0000");
        visited.add("0000");

        int ans = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                if (deadendSet.contains(curr)) {
                    continue;
                }
                if (curr.equals(target)) {
                    return ans;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(curr, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }

                    String down = minusOne(curr, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            ans++;
        }

        return -1;
    }

    private String plusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }

        return new String(chars);
    }

    private String minusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }

        return new String(chars);
    }
}