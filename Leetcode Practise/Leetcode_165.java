import java.util.Scanner;

public class Leetcode_165 {
    public int compareVersion(String version1, String version2) {
        Scanner sc1 = new Scanner(version1);
        Scanner sc2 = new Scanner(version2);
        sc1.useDelimiter("\\.");
        sc2.useDelimiter("\\.");
        while (sc1.hasNext() || sc2.hasNext()) {
            int token1 = 0;
            int token2 = 0;

            if (sc1.hasNext()) {
                token1 = Integer.parseInt(sc1.next());
            }
            if (sc2.hasNext()) {
                token2 = Integer.parseInt(sc2.next());
            }

            if (token1 > token2) {
                sc1.close();
                sc2.close();
                return 1;
            } else if (token1 < token2) {
                sc1.close();
                sc2.close();
                return -1;
            }
        }
        sc1.close();
        sc2.close();
        return 0;
    }
}
