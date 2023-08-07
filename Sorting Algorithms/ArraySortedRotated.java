import java.util.Arrays;

public class ArraySortedRotated {
   public boolean check(int[] nums) {
      int n = nums.length;
      int temp[] = new int [n];
      for(int i=0;i<n;i++) {
         temp[i]=nums[i];
      }
      Arrays.sort(nums);
      // printArray(nums);
      int x = nums[0];
      int pos = -1;
      // System.out.println(x);
      for (int i = 0; i < n; i++) {
         if (temp[i] == x) {
            pos = i;
            break;
         }
      }

      boolean flag = false;
      int prev = temp[pos];
      for (int i = pos + 1; i < n; i++) {
         if (temp[i] >= prev) {
            flag = true;
            prev=temp[i];
            
         } else {
            flag = false;
            break;
         }
      }
      // System.out.println(pos);
      for (int i = 0; i < pos; i++) {
         // System.out.println("inside");
         if (temp[i] < prev) {
            flag = false;
            // System.out.println("inside");
            break;
         } else {
            prev = temp[i];
            flag = true;
         }
      }
      return flag;
   }

   public void printArray(int arr[]) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
   public static void main(String[] args) {
      ArraySortedRotated obj = new ArraySortedRotated();
      int nums[] = {2,1,3,4};
      System.out.println(obj.check(nums)); 
   }
}