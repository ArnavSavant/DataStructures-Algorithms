public class Leetcode_3270 {
    public int generateKey(int num1, int num2, int num3) {
        int key = 0;
        for (int i = 0; i < 4; i++) {
            int digit = Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10);
            key = key + digit * (int) Math.pow(10, i);
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return key;
    }
}