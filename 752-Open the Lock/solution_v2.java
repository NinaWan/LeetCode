class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }

        Set<String> q1 = new HashSet();
        Set<String> q2 = new HashSet();
        Set<String> visited = new HashSet();
        q1.add("0000");
        q2.add(target);

        int ans = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet();

            for (String curr : q1) {
                if (deadendSet.contains(curr)) {
                    continue;
                }
                if (q2.contains(curr)) {
                    return ans;
                }

                visited.add(curr);

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(curr, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }

                    String down = minusOne(curr, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            ans++;

            q1 = q2;
            q2 = temp;
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