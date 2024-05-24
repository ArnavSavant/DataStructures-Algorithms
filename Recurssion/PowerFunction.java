public class PowerFunction {
    public double myPow(double x, int n) {
        if (x == 1.0 || n == 0) {
            return 1.0;
        }
        if (n == Integer.MIN_VALUE) {
            return myPow(x * x, Integer.MIN_VALUE / 2);
        } else if (n > 0) {
            return posPow(x, n);
        } else {
            return 1 / posPow(x, n * -1);
        }
    }

    public double posPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        return (n % 2 == 0 ? posPow(x * x, n / 2) : x * posPow(x, n - 1));
    }

    public static void main(String[] args) {
        PowerFunction obj = new PowerFunction();
        System.out.println("value of 6 to the power 8 is " + obj.myPow(6.0, 8));
    }
}
