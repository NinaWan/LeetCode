class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList();

        String root = folder[0];
        result.add(root);
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(root + "/")) {
                root = folder[i];
                result.add(root);
            }
        }

        return result;
    }
}