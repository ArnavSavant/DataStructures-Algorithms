public class Leetcode_3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int temp = x;
        int sum = 0;
        while (temp != 0) {
            sum = sum + temp % 10;
            temp = temp / 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}
