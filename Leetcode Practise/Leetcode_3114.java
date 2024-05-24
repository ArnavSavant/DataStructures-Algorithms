public class Leetcode_3114 {
    public String findLatestTime(String s) {
        StringBuffer sb = new StringBuffer();

        if (s.charAt(0) == '?') {
            if (s.charAt(1) == '?' || s.charAt(1) == '0' || s.charAt(1) == '1') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        } else {
            sb.append(s.charAt(0));
        }

        if (s.charAt(1) == '?') {
            if (s.charAt(0) == '?' || s.charAt(0) == '1') {
                sb.append('1');
            } else {
                sb.append('9');
            }
        } else {
            sb.append(s.charAt(1));
        }

        sb.append(':');

        if (s.charAt(3) == '?') {
            sb.append('5');
        } else {
            sb.append(s.charAt(3));
        }

        if (s.charAt(4) == '?') {
            sb.append('9');
        } else {
            sb.append(s.charAt(4));
        }

        return sb.toString();
    }
}
