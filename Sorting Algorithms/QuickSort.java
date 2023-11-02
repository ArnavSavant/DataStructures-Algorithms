//Quick Sort is a divide and conquer algorithm. It involves three steps:
//Pivot Selection --> We pick an element and mark it as pivot. The pivot element can be first, last or any random element.
//Partioning --> We record the array such that all elements smaller then pivot come before the pivot and all elements greater than pivot comes after the pivot.
//Recursion --> Recursively apply the above steps on the subarray formed to the left side of pivot and on the subarray formed on the right side of the pivot.

public class QuickSort {

   public void sort(int arr[], int i, int j) {
      if (i < j) {
         int pivot = partition(arr, 0, j);
         sort(arr, i, pivot - 1);
         sort(arr, pivot + 1, j);
      }
   }
   public int partition(int arr[], int low, int high) {
      int pivot = arr[high];
      int i = low;
      int j = low;
      // low to j-1 --> elements smaller than or equal to pivot
      // j to i-1 --> elements greater than pivot
      // i to high --> elements yet to traverse and check
      while (i <= high) {
         if (arr[i] <= pivot) {
            swap(arr, i, j);
            j++;
         }
         i++;
      }
      // printArray(arr);
      return j - 1;
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
      QuickSort obj = new QuickSort();
      int arr[] = { 5, 9, 6, 3, 4, 2, 8, 1 };
      System.out.println("Before Sorting");
      obj.printArray(arr);
      System.out.println();
      obj.sort(arr, 0,arr.length-1);
      System.out.println("After Sorting");
      obj.printArray(arr);
   }
}
