public class TappingRainWater {
   // public int solve(int arr[]) {
   // int leftMax[] = new int[arr.length];
   // int rightMax[] = new int[arr.length];
   // int sum = 0;
   // int max = Integer.MIN_VALUE;
   // for (int i = 0; i < arr.length; i++) {
   // max = Math.max(max, arr[i]);
   // leftMax[i] = max;
   // }
   // max = Integer.MIN_VALUE;
   // for (int i = arr.length - 1; i >= 0; i--) {
   // max = Math.max(max, arr[i]);
   // rightMax[i] = max;
   // }
   // for (int i = 0; i < arr.length; i++) {
   // sum = sum + Math.min(leftMax[i], rightMax[i]) - arr[i];
   // }
   // return sum;
   // }
   public int trap(int[] heights) {
      int tappedWater = 0;
      int left = 0;
      int right = heights.length - 1;
      int leftMax = heights[left];
      int rightMax = heights[right];
      while (left <= right) {
         if (heights[left] <= heights[right]) {
            leftMax = Math.max(leftMax, heights[left]);
            tappedWater = tappedWater + (leftMax - heights[left]);
            left++;
         } else {
            rightMax = Math.max(rightMax, heights[right]);
            tappedWater = tappedWater + (rightMax - heights[right]);
            right--;
         }
      }
      return tappedWater;
   }

   public static void main(String[] args) {
      TappingRainWater obj = new TappingRainWater();
      int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
      System.out.println(obj.trap(arr));
   }
}
