public class Leetcode_592 {
    public int HCF(int a, int b) {
        if (b == 0) {
            return a;
        }
        return HCF(b, a % b);
    }

    public String fractionAddition(String expression) {
        int i = 0;
        int currSign = 0;
        int currNum = 0;
        int currDen = 0;
        while (i < expression.length()) {
            int sign = 1;
            int num = 0;
            int den = 0;
            if (expression.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (expression.charAt(i) == '+') {
                sign = 1;
                i++;
            }

            while (expression.charAt(i) != '/') {
                num = num * 10 + expression.charAt(i) - '0';
                i++;
            }
            i++;

            while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-') {
                den = den * 10 + expression.charAt(i) - '0';
                i++;
            }
            num = num * sign;
            if (currSign == 0) {
                currSign = sign;
                currNum = num;
                currDen = den;
            } else {
                int hcf = HCF(currDen, den);
                int lcm = (currDen * den) / hcf;
                currNum = currNum * (lcm / currDen) + num * (lcm / den);
                currDen = lcm;
                currSign = currNum < 0 ? -1 : 1;
            }
        }
        int hcf = HCF(Math.abs(currNum), currDen);
        currNum = currNum / hcf;
        currDen = currDen / hcf;
        return currNum + "/" + currDen;
    }

    public static void main(String[] args) {
        Leetcode_592 obj = new Leetcode_592();
        System.out.println(obj.fractionAddition("-1/2+1/2"));
        System.out.println(obj.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(obj.fractionAddition("1/3-1/2"));
        System.out.println(obj.fractionAddition("5/3+1/3"));
    }
}
