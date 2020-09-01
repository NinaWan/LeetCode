class Solution {
    public String validIPAddress(String IP) {
        if (null == IP || IP.length() < 7) {
            return "Neither";
        }

        if (IP.charAt(0) == '.' || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == '.' || IP.charAt(IP.length() - 1) == ':') {
            return "Neither";
        }

        String[] parts = IP.split("\\.");
        if (parts.length == 4) {// check if is IPv4
            boolean isIPv4 = true;
            for (String part : parts) {
                if (part.length() > 3 || !part.matches("[0-9]+")) {
                    isIPv4 = false;
                    break;
                }

                int val = Integer.valueOf(part);
                if ((part.length() > 1 && part.charAt(0) == '0') || val > 255) {
                    isIPv4 = false;
                    break;
                }
            }

            if (isIPv4) {
                return "IPv4";
            }
        }

        parts = IP.split(":");
        if (parts.length == 8) {// check if is IPv6
            boolean isIPv6 = true;
            for (String part : parts) {
                if (part.length() > 4 || !part.matches("([A-F]|[a-f]|[0-9])+")) {
                    isIPv6 = false;
                    break;
                }
            }

            if (isIPv6) {
                return "IPv6";
            }
        }

        return "Neither";
    }
}