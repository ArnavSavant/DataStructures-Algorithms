public class CountSort {
   public void sort(int arr[], int n) {
      int max = findMaximum(arr, n);
      int count[] = new int[max + 1];

      for (int i = 0; i <= max; i++) {
         count[i] = 0; // initializing count array;
      }

      for (int i = 0; i < n; i++) {
         count[arr[i]]++; // counting array elements
      }
      int k = 0;
      // int step=0;
      for (int i = 0; i <= max; i++) {
         // step++;
         while (count[i] > 0) {
            arr[k++] = i;
            count[i]--;
            // step++;
         }
      }
      // System.out.println(step);
   }

   public int findMaximum(int arr[], int n) {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
         max = Math.max(arr[i], max);
      }
      return max;
   }

   public void printArray(int arr[]) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) {
      CountSort obj = new CountSort();
      int arr[] = { 5, 9, 6, 3, 4, 2, 8, 1 };
      System.out.println("Before Sorting");
      obj.printArray(arr);
      System.out.println();
      obj.sort(arr, arr.length);
      System.out.println("After Sorting");
      obj.printArray(arr);
   }
}
