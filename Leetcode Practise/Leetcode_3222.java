public class Leetcode_3222 {
    public String losingPlayer(int x, int y) {
        int min = Math.min(x, y / 4);
        if (min % 2 == 1) {
            return "Alice";
        } else {
            return "Bob";
        }
    }
}
