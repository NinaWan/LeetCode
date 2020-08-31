class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList();
        boolean inBlock = false;
        String code = "";

        for (String line : source) {
            if (!inBlock) {
                code = "";
            }

            for (int i = 0; i < line.length(); i++) {
                if (i == line.length() - 1) { // last char
                    if (!inBlock) {
                        code += Character.toString(line.charAt(i));
                    }
                } else {
                    if (line.charAt(i) == '/' && line.charAt(i + 1) == '*') {// blocking comment opening
                        if (!inBlock) {
                            inBlock = true;
                            i++;
                        }
                    } else if (line.charAt(i) == '*' && line.charAt(i + 1) == '/') {// blocking comment closing
                        if (inBlock) {
                            inBlock = false;
                            i++;
                        } else {
                            code += Character.toString(line.charAt(i));
                        }
                    } else if (line.charAt(i) == '/' && line.charAt(i + 1) == '/') {// line comment
                        if (!inBlock) {
                            i = line.length();
                        }
                    } else {
                        if (!inBlock) {
                            code += Character.toString(line.charAt(i));
                        }
                    }
                }
            }

            if (!inBlock && !code.equals("")) {
                ans.add(code);
            }
        }

        return ans;
    }
}