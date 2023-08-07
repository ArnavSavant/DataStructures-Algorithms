import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxOfAllSubarrayOfSizeK {
   public Object solve(int arr[], int k) {
      List<Integer> ans = new ArrayList<Integer>();
      int i = 0;
      int j = 0;
      int n = arr.length;
      Queue<Integer> temp = new LinkedList<>();
      while (j < n) {
         while (temp.size() > 0 && temp.peek() < arr[j]) {
            temp.remove();
         }
         temp.add(arr[j]);

         if (j - i + 1 < k) {
            j++;
         } else if (j - i + 1 == k) {
            ans.add(temp.peek());

            if (temp.peek() == arr[i]) {
               temp.remove();
               while (temp.size() > 0 && temp.peek() < arr[j]) {
                  temp.remove();
               }
            }

            i++;
            j++;
         }
      }
      return ans;
   }

   public static void main(String[] args) {
      MaxOfAllSubarrayOfSizeK obj = new MaxOfAllSubarrayOfSizeK();
      int arr[] = { 2, 3, -1, 1, -7, 2, 4, -6, 9 };
      System.out.println(obj.solve(arr, 3));
   }
}
