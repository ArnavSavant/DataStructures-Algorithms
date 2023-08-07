import java.util.ArrayList;
import java.util.List;

public class PowerSet {
   public List<List<Integer>> solve(int nums[]) {
      List<List<Integer>> ans = new ArrayList<>();
      int n = nums.length;
      for (int i = 0; i < (int) (Math.pow(2, n)); i++) {
         List<Integer> list = new ArrayList<>();
         int num = i;
         int count = 0;
         while (num != 0) {
            if ((num & 1) == 1) {
               list.add(nums[count]);
            }
            count++;
            num = num >> 1;
         }
         ans.add(new ArrayList<>(list));
      }
      return ans;
   }
   public static void main(String[] args) {
      PowerSet obj = new PowerSet();
      int arr[] = {1,3,5};
      System.out.println(obj.solve(arr));
   }
}
