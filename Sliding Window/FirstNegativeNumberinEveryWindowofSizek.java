import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumberinEveryWindowofSizek {
   // public Object solve(int arr[], int k) {
   // int n = arr.length;
   // List<Integer> list = new ArrayList<Integer>();
   // int i;
   // int j;
   // boolean flag;
   // for (i = 0; i < n - k + 1; i++) {

   // flag = false;
   // for (j = i; j < i + k; j++) {
   // if (arr[j] < 0) {
   // flag = true;
   // break;
   // }
   // }
   // if (flag) {
   // list.add(arr[j]);
   // } else {
   // list.add(0);
   // }
   // }
   // return list;
   // }

   public void solve(int arr[], int k) {
      int n = arr.length;
      int i = 0; // denoting start of window
      int j = 0; // denoting end of window
      List<Integer> list = new ArrayList<Integer>();
      while (j < n) {
         if (arr[j] < 0) {
            list.add(arr[j]);
         }
         if (j - i + 1 < k) {
            j++;
         } else if (j - i + 1 == k) {
            if (list.size() == 0) {
               System.out.print(0 + "  ");
            } else {
               System.out.print(list.get(0) + "  ");
               // System.out.println(list);
               if (arr[i] == list.get(0)) {
                  list.remove(0);
               }
            }
            i++;
            j++;
         }
      }
   }

   public static void main(String[] args) {
      FirstNegativeNumberinEveryWindowofSizek obj = new FirstNegativeNumberinEveryWindowofSizek();
      int arr[] = { 2, -1, 5, -6, 8, -9, 3, 7, -10, 63, 45, 82, -7 };
      obj.solve(arr, 3);
      // System.out.println(obj.solve(arr, 3));
   }
}
