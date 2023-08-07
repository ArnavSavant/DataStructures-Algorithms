public class BubbleSortRecursive {
   public void sort(int arr[], int n) {
      if (n == 1) {
         return;
      }

      boolean flag = false;
      for (int i = 0; i < n - 1; i++) {
         if (arr[i] > arr[i + 1]) {
            swap(arr, i, i + 1);
            flag = true;
         }
      }
      if (!flag) {
         return;
      }

      sort(arr, n - 1);
   }

   public void swap(int arr[], int i, int j) { // swap function
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public void printArray(int arr[]) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) {
      BubbleSortRecursive obj = new BubbleSortRecursive();
      int arr[] = { 5, 9, 6, 3, 4, 2, 8, 1 };
      System.out.println("Before Sorting");
      obj.printArray(arr);
      System.out.println();
      obj.sort(arr, arr.length);
      System.out.println("After Sorting");
      obj.printArray(arr);
   }
}