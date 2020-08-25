class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();

        for (String email : emails) {
            String[] parts = email.split("@");
            set.add(parts[0].split("\\+")[0].replaceAll("\\.", "") + "@" + parts[1]);
        }

        return set.size();
    }
}