public class Leetcode_1137 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int term = 0;
        while (n >= 3) {
            term = a + b + c;
            a = b;
            b = c;
            c = term;
            n--;
        }
        return term;
    }
}
