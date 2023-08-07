public class DriverProgram {
   public static int solve(int n, int[] cost, int[] time) {
      int paid = 0;
      int minCost = 0;
      int i=0;
      while(i<n) {
         if(paid==0) {
            paid=paid+time[i];
            minCost=minCost + cost[i];
         }
         else if(paid != 0) {
            i=i+time[i];
            paid=0;
            i++;
         }
         
      }
      return minCost;
   }
   public static void main(String[] args) {
      int cost[] = {1,1,3,4,5,9,3,1};
      int time[] = {3,1,2,3,2,4,4,6};
      System.out.println(solve(8,cost,time));
   }
}