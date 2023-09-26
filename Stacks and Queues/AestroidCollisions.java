import java.util.Stack;
public class AestroidCollisions {
   public int[] solve(int[] asteroids) {
      Stack<Integer> stack = new Stack<Integer>();
      for (int i = 0; i < asteroids.length; i++) {
         int x = asteroids[i];
         boolean flag = true;
         while (stack.size() > 0 && stack.peek() > 0 && x < 0) {
            int y = stack.pop();
            if (Math.abs(y) > Math.abs(x)) {
               x = y;
            } else if (x == -y) {
               flag = false;
               break;
            }
         }
         if (flag) {
            stack.push(x);
         }
      }
      int res[] = new int[stack.size()];
      for (int i = stack.size() - 1; i >= 0; i--) {
         res[i] = stack.pop();
      }
      return res;
   }
   public static void main(String[] args) {
      AestroidCollisions obj = new AestroidCollisions();
      int arr[] = {-2,-1,1,2};
      int ans[] = obj.solve(arr);
      for(int x : ans) {
         System.out.print(x+" , ");
      }
   }
}
