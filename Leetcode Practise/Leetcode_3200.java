public class Leetcode_3200 {
    public int maxHeightOfTriangle(int red, int blue) {
        int tempRed = red;
        int tempBlue = blue;
        int height1 = 0;
        boolean isRed = true;
        while (red >= 0 && blue >= 0) {
            if (isRed) {
                red = red - height1 - 1;
                isRed = false;
            } else {
                blue = blue - height1 - 1;
                isRed = true;
            }
            height1++;
        }
        red = tempRed;
        blue = tempBlue;
        int height2 = 0;
        isRed = false;
        while (red >= 0 && blue >= 0) {
            if (isRed) {
                red = red - height2 - 1;
                isRed = false;
            } else {
                blue = blue - height2 - 1;
                isRed = true;
            }
            height2++;
        }
        return Math.max(height1, height2)-1;
    }
}
