class Solution {
    public String defangIPaddr(String address) {
        if (null == address) {
            return null;
        }

        return address.replaceAll("\\.", "[.]");
    }
}