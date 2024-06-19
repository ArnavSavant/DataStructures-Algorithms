import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Leetcode_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<String>(dictionary);
        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(sentence);
        while (sc.hasNext()) {
            String token = sc.next();
            StringBuffer temp = new StringBuffer();
            for (int i = 0; i < token.length(); i++) {
                temp.append(token.charAt(i));
                if (set.contains(temp.toString())) {
                    break;
                }
            }
            sb.append(temp);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sc.close();

        return sb.toString();
    }
}
