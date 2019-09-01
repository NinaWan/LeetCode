class Solution {
    public int numUniqueEmails(String[] emails) {
        if (null == emails || emails.length == 0) {
            return 0;
        }

        Set<String> result = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            String[] email = emails[i].split("@");
            String processedLocal = email[0].split("\\+")[0].replaceAll("\\.", "");
            result.add(processedLocal + "@" + email[1]);
        }

        return result.size();
    }
}