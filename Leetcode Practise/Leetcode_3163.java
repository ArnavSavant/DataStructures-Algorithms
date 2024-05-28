public class Leetcode_3163 {
    public String compressedString(String word) {
        if (word.length() == 1) {
            return "1" + word;
        }
        StringBuffer sb = new StringBuffer();
        char prevChar = word.charAt(0);
        int currLen = 1;
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == prevChar) {
                currLen++;
                if (currLen == 9) {
                    sb.append(currLen);
                    sb.append(c);
                    currLen = 0;
                }

            } else {
                if (currLen != 0) {
                    sb.append(currLen);
                    sb.append(prevChar);
                }
                currLen = 1;
            }
            prevChar = c;
        }
        if (currLen != 0) {
            sb.append(currLen);
            sb.append(prevChar);
        }
        return sb.toString();
    }
}
