class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Set<String> letLogs = new TreeSet<String>((a, b) -> {
            int as = a.indexOf(" ");
            int bs = b.indexOf(" ");
            String alog = a.substring(as + 1, a.length());
            String blog = b.substring(bs + 1, b.length());

            if (alog.equals(blog)) {
                return a.substring(0, as).compareTo(b.substring(0, bs));
            }

            return alog.compareTo(blog);
        });
        List<String> orderedLogs = new ArrayList();

        for (String log : logs) {
            char first = log.split(" ")[1].charAt(0);
            if (first >= '0' && first <= '9') {
                orderedLogs.add(log);
            } else {
                letLogs.add(log);
            }
        }

        orderedLogs.addAll(0, letLogs);

        return orderedLogs.toArray(new String[0]);
    }
}