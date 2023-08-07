//Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. This algorithm is not suitable for large data sets as its average and worst-case time complexity is quite high.
//The worst case for bubble sort occurs when array is sorted in decreasing order.

public class BubbleSort {
   public int[] sort(int arr[], int n) {
      for (int i = 0; i < n - 1; i++) {
         boolean swapped = false;
         for (int j = 0; j < n - 1 - i; j++) { // (j<n-1-i) -> [-i] is added for optimization since array will be sorted
                                               // from right after every iteration
            if (arr[j + 1] < arr[j]) { // swapping adjacent element
               swapped = true;
               swap(arr, j, j + 1);
            }
         }
         if(!swapped) {
            break;
         }
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
      BubbleSort obj = new BubbleSort();
      int arr[] = { 5, 9, 6, 3, 4, 2, 8, 1 };
      System.out.println("Before Sorting");
      obj.printArray(arr);
      System.out.println();
      arr = obj.sort(arr, arr.length);
      System.out.println("After Sorting");
      obj.printArray(arr);
   }
}
