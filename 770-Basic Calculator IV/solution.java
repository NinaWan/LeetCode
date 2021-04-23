class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> evalMap = new HashMap();

        for (int i = 0; i < evalvars.length; i++) {
            evalMap.put(evalvars[i], evalints[i]);
        }

        return parse(expression).evaluate(evalMap).toList();
    }

    private Poly parse(String expression) {
        List<Poly> bucket = new ArrayList();
        List<Character> symbols = new ArrayList();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                int start = i + 1, bal = 0;
                while (i < expression.length()) {
                    if (expression.charAt(i) == '(') {
                        bal++;
                    } else if (expression.charAt(i) == ')') {
                        bal--;
                    }

                    if (bal == 0) {
                        break;
                    }

                    i++;
                }
                bucket.add(parse(expression.substring(start, i)));
            } else if (Character.isLetterOrDigit(c)) {
                int start = i;
                while (i < expression.length() && expression.charAt(i) != ' ') {
                    i++;
                }
                bucket.add(make(expression.substring(start, i)));
            } else if (c != ' ') {// symbol
                symbols.add(c);
            }
        }

        for (int i = symbols.size() - 1; i >= 0; i--) {// multiplication
            if (symbols.get(i) == '*') {
                Poly left = bucket.get(i);
                Poly right = bucket.remove(i + 1);
                bucket.set(i, combine(left, right, symbols.remove(i)));
            }
        }

        if (bucket.isEmpty()) {
            return new Poly();
        }

        Poly ans = bucket.get(0);
        for (int i = 0; i < symbols.size(); i++) {// addition and subtraction
            ans = combine(ans, bucket.get(i + 1), symbols.get(i));
        }

        return ans;
    }

    private Poly make(String expression) {
        Poly ans = new Poly();
        List<String> key = new ArrayList();

        if (Character.isDigit(expression.charAt(0))) {// is a number
            ans.update(key, Integer.valueOf(expression));
        } else {// is a word
            key.add(expression);
            ans.update(key, 1);
        }

        return ans;
    }

    private Poly combine(Poly left, Poly right, Character symbol) {
        if (symbol == '+') {
            return left.add(right);
        } else if (symbol == '-') {
            return left.sub(right);
        } else if (symbol == '*') {
            return left.mul(right);
        }

        return left;
    }

    private class Poly {
        private Map<List<String>, Integer> count;

        public Poly() {
            this.count = new HashMap();
        }

        public void update(List<String> key, int val) {
            this.count.put(key, this.count.getOrDefault(key, 0) + val);
        }

        public Poly add(Poly that) {
            Poly ans = new Poly();

            for (Map.Entry<List<String>, Integer> entry : this.count.entrySet()) {
                ans.update(entry.getKey(), entry.getValue());
            }
            for (Map.Entry<List<String>, Integer> entry : that.count.entrySet()) {
                ans.update(entry.getKey(), entry.getValue());
            }

            return ans;
        }

        public Poly sub(Poly that) {
            Poly ans = new Poly();

            for (Map.Entry<List<String>, Integer> entry : this.count.entrySet()) {
                ans.update(entry.getKey(), entry.getValue());
            }
            for (Map.Entry<List<String>, Integer> entry : that.count.entrySet()) {
                ans.update(entry.getKey(), -entry.getValue());
            }

            return ans;
        }

        public Poly mul(Poly that) {
            Poly ans = new Poly();

            for (Map.Entry<List<String>, Integer> thisEntry : this.count.entrySet()) {
                for (Map.Entry<List<String>, Integer> thatEntry : that.count.entrySet()) {
                    List<String> key = new ArrayList();
                    key.addAll(thisEntry.getKey());
                    key.addAll(thatEntry.getKey());
                    Collections.sort(key);
                    ans.update(key, thisEntry.getValue() * thatEntry.getValue());
                }
            }

            return ans;
        }

        public Poly evaluate(Map<String, Integer> evalMap) {
            Poly ans = new Poly();

            for (Map.Entry<List<String>, Integer> entry : this.count.entrySet()) {
                int c = entry.getValue();
                List<String> free = new ArrayList();

                for (String token : entry.getKey()) {
                    if (evalMap.containsKey(token)) {
                        c *= evalMap.get(token);
                    } else {
                        free.add(token);
                    }
                }

                ans.update(free, c);
            }

            return ans;
        }

        public List<String> toList() {
            List<String> ans = new ArrayList();
            List<List<String>> keys = new ArrayList(this.count.keySet());
            Collections.sort(keys, (a, b) -> {
                return a.size() != b.size() ? b.size() - a.size()
                                            : compareList(a, b);
            });

            for (List<String> key : keys) {
                int value = this.count.get(key);
                if (value != 0) {
                    String word = "" + value;
                    for (String token : key) {
                        word += "*" + token;
                    }
                    ans.add(word);
                }
            }

            return ans;
        }

        private int compareList(List<String> a, List<String> b) {
            for (int i = 0; i < a.size(); i++) {
                String x = a.get(i);
                String y = b.get(i);
                if (x.compareTo(y) != 0) {
                    return x.compareTo(y);
                }
            }

            return 0;
        }
    }
}