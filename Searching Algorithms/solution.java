public class solution {
   public static void longestIncreasingSeq(int input1, int[] input2) {
      int max = -1;
      int count = 1;
      for (int i = 0; i < input1 - 1; i++) {
         if (input2[i + 1] > input2[i]) {
            max = Math.max(count, max);
            count++;
         } else {
            count = 1;
         }
      }
      if (max == -1) {
         System.out.println(0);
      } else {
         System.out.println(max);
      }
   }

   public static void main(String[] args) {
      int arr[] = { 1, 2, 1, 2, 3 };
      longestIncreasingSeq(arr.length, arr);
   }
}
