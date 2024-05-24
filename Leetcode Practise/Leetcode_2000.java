public class Leetcode_2000 {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int ind = word.indexOf(ch);
        if (ind == -1) {
            return word;
        }
        sb.append(word.substring(0, ind + 1));
        sb.reverse();
        sb.append(word.substring(ind + 1));
        return sb.toString();
    }
}
