public class Leetcode_476 {
    public int findComplement(int num) {
        int noOfBits = (int) Math.floor((Math.log(num) / Math.log(2) + 1));
        int mask = (1 << noOfBits) - 1;
        return num ^ mask;
    }
}
