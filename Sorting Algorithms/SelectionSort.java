//The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
// The subarray which is already sorted. 
// Remaining subarray which is unsorted.

public class SelectionSort {
   public int[] sort(int arr[], int n) {
      for (int i = 0; i < n - 1; i++) {
         int min = i;
         for (int j = i + 1; j < n; j++) {
            if(arr[j]<arr[min]) {
               min=j;
            }
         }
         swap(arr, i, min);
      }
      return arr;
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
      SelectionSort obj = new SelectionSort();
      int arr[] = { 5, 9, 6, 3, 4, 2, 8, 1 };
      System.out.println("Before Sorting");
      obj.printArray(arr);
      System.out.println();
      arr = obj.sort(arr, arr.length);
      System.out.println("After Sorting");
      obj.printArray(arr);
   }
}
