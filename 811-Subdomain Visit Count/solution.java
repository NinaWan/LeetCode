class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList();
        Map<String, Integer> visits = new HashMap();

        for (String cpdomain : cpdomains) {
            String[] cp = cpdomain.split(" ");
            int count = Integer.valueOf(cp[0]);
            visits.put(cp[1], visits.getOrDefault(cp[1], 0) + count);

            String[] domains = cp[1].split("\\.");
            String subdomain = domains[domains.length - 1];
            for (int i = domains.length - 2; i >= 0; i--) {
                visits.put(subdomain, visits.getOrDefault(subdomain, 0) + count);
                subdomain = domains[i] + "." + subdomain;
            }
        }

        for (Map.Entry<String, Integer> visit : visits.entrySet()) {
            ans.add(visit.getValue() + " " + visit.getKey());
        }

        return ans;
    }
}