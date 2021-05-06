class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack();
        int n = code.length();

        for (int i = 0; i < code.length();) {
            if (i > 0 && stack.isEmpty()) {// run out of start tag
                return false;
            }

            if (code.startsWith("<![CDATA[", i)) {// cdata
                if (i == 0) {
                    return false;
                }
                int endCdata = code.indexOf("]]>", i + 9);
                if (endCdata == -1) {// not found
                    return false;
                }
                i = endCdata + 3;
            } else if (code.startsWith("</", i)) {// end tag
                int endTag = code.indexOf(">", i + 2);
                if (endTag == -1) {
                    return false;
                }
                String tagName = code.substring(i + 2, endTag);
                if (!isValidTagName(tagName) || stack.isEmpty() || !stack.pop().equals(tagName)) {
                    return false;
                }
                i = endTag + 1;
            } else if (code.startsWith("<", i)) {// start tag
                int startTag = code.indexOf(">", i + 1);
                if (startTag == -1) {
                    return false;
                }
                String tagName = code.substring(i + 1, startTag);
                if (!isValidTagName(tagName)) {
                    return false;
                }
                stack.push(tagName);
                i = startTag + 1;
            } else {// other characters
                if (i == 0) {
                    return false;
                }
                i++;
            }
        }

        return stack.isEmpty();
    }

    private boolean isValidTagName(String tagName) {
        if (tagName.length() < 1 || tagName.length() > 9) {
            return false;
        }

        for (char c : tagName.toCharArray()) {
            if (c > 'Z' || c < 'A') {
                return false;
            }
        }

        return true;
    }
}