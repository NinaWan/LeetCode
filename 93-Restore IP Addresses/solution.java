class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
        int n = s.length();

        if (n < 4 || n > 12) {
            return ans;
        }

        for (int i = 1; i <= 3; i++) {
            if (n - i < 3 || (i != 1 && s.charAt(0) == '0')) {
                break;
            }

            if (n - i > 9) {
                continue;
            }

            int a = Integer.valueOf(s.substring(0, i));
            if (a > 255) {
                continue;
            }

            for (int j = i + 1; j <= i + 3; j++) {
                if (n - j < 2 || (j != i + 1 && s.charAt(i) == '0')) {
                    break;
                }

                if (n - j > 6) {
                    continue;
                }

                int b = Integer.valueOf(s.substring(i, j));
                if (b > 255) {
                    continue;
                }

                for (int k = j + 1; k <= j + 3; k++) {
                    if (n - k < 1 || (k != j + 1 && s.charAt(j) == '0')) {
                        break;
                    }

                    if (n - k > 3) {
                        continue;
                    }

                    int c = Integer.valueOf(s.substring(j, k));
                    if (c > 255) {
                        continue;
                    }

                    String ds = s.substring(k, n);
                    int d = Integer.valueOf(ds);

                    if ((n - k != 1 && ds.charAt(0) == '0') || d > 255) {
                        continue;
                    }

                    ans.add(a + "." + b + "." + c + "." + d);
                }
            }
        }

        return ans;
    }
}