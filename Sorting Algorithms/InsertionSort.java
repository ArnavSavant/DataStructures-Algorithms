//Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.

public class InsertionSort {
   public int[] sort(int arr[], int n) {
      int step=0;
      for(int i=1;i<n;i++) {
         int temp=arr[i]; //storing to prevent it's loss
         int j=i-1;
         while(j>=0 && arr[j]>temp) {
            arr[j+1]=arr[j]; //shifting elements to the right in sorted array until apt possition of temp is found
            j--;
            step++;
         }
         arr[j+1]=temp;
         // printArray(arr);
         // System.out.println("");
      }
      System.out.println(step);
      return arr;
   }
   public void printArray(int arr[]) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
   public static void main(String[] args) {
      InsertionSort obj = new InsertionSort();
      int arr[] = { 5, 9, 6, 3, 4, 2, 8, 1 };
      System.out.println("Before Sorting");
      obj.printArray(arr);
      System.out.println();
      arr = obj.sort(arr, arr.length);
      System.out.println("After Sorting");
      obj.printArray(arr);
   }
}
 