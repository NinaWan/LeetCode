class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.replace("/./", "/").replaceAll("/+", "/").replace("/./", "/").split("/");
        String ans = "";

        int up = 0;
        for (int i = dirs.length - 1; i >= 0; i--) {
            if (dirs[i].equals("..")) {
                up++;
            } else {
                if (up == 0 && !"".equals(dirs[i]) && !".".equals(dirs[i])) {
                    ans = "/" + dirs[i] + ans;
                } else if (!"".equals(dirs[i]) && !".".equals(dirs[i])) {
                    up--;
                }
            }
        }

        return ans.isEmpty() ? "/"
                             : ans;
    }
}