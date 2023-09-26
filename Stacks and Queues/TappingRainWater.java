public class TappingRainWater {
   public int solve(int arr[]) {
      int leftMax[] = new int[arr.length];
      int rightMax[] = new int[arr.length];
      int sum = 0;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < arr.length; i++) {
         max = Math.max(max, arr[i]);
         leftMax[i] = max;
         System.out.print(leftMax[i]+" , ");
      }
      max = Integer.MIN_VALUE;
      for (int i = arr.length - 1; i >= 0; i--) {
         max = Math.max(max, arr[i]);
         rightMax[i] = max;
      }
      System.out.println("");
      for (int i = 0; i < arr.length; i++) {
         System.out.print(rightMax[i] + " , ");
      }
      System.out.println("");
      for (int i = 0; i < arr.length; i++) {
         sum = sum + Math.min(leftMax[i], rightMax[i]) - arr[i];
      }
      return sum;
   }

   public static void main(String[] args) {
      TappingRainWater obj = new TappingRainWater();
      int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
      System.out.println(obj.solve(arr));
   }
}
