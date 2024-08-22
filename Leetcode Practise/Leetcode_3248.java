import java.util.List;

public class Leetcode_3248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int h = 0;
        int v = 0;
        for (String command : commands) {
            if (command.equals("UP")) {
                v--;
            } else if (command.equals("DOWN")) {
                v++;
            } else if (command.equals("LEFT")) {
                h--;
            } else if (command.equals("RIGHT")) {
                h++;
            }
        }
        return (v * n) + h;
    }
}
