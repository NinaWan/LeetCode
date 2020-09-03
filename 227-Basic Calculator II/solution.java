class Solution {
    public int calculate(String s) {
        List<String> vars = new ArrayList();
        Stack<String> stack = new Stack();
        LinkedList<String> list = new LinkedList();
        String num = "";
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num += Character.toString(c);
            } else {
                if (!num.isEmpty()) {
                    vars.add(num);
                    num = "";
                }

                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    vars.add(Character.toString(c));
                }
            }
        }

        if (!num.isEmpty()) {
            vars.add(num);
        }

        int p = -1;
        for (int i = 0; i < vars.size(); i++) {
            String var = vars.get(i);
            if (var.equals("/")) {
                list.set(p, String.valueOf(Long.valueOf(list.get(p)) / Long.valueOf(vars.get(++i))));
            } else if (var.equals("*")) {
                list.set(p, String.valueOf(Long.valueOf(list.get(p)) * Long.valueOf(vars.get(++i))));
            } else {
                if (list.size() <= p + 1) {
                    list.add(var);
                    p++;
                } else {
                    list.set(++p, var);
                }
            }
        }

        long ans = 0;
        while (!list.isEmpty() && p >= 0) {
            String top = list.poll();
            p--;
            if (top.equals("+") || top.equals("-")) {
                long next = Long.valueOf(list.poll());
                p--;

                if (top.equals("-")) {
                    ans -= next;
                } else {
                    ans += next;
                }
            } else {
                ans = Long.valueOf(top);
            }
        }

        return (int) ans;
    }
}