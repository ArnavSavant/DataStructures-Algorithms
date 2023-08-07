public class EggDroppingProblem {
   static int t[][] = new int[4][6];
   public void initialize() {
      for(int i=0;i<4;i++) {
         for(int j=0;j<6;j++) {
            t[i][j]=-1;
         }
      }
   }
   public void display(int arr[][]) {
      for(int i=0;i<4;i++) {
         for(int j=0;j<6;j++) {
            System.out.print(arr[i][j]+" ");
         }
         System.out.println();
      }
   }
   public int solve(int e, int f) {
      if(f==0 || f==1) {
         t[e][f]=f;
         return f;
      }
      if(e==1) {
         t[e][f]=f;
         return f;
      }
      if(t[e][f] != -1) {
         return t[e][f];
      }
      int min=Integer.MAX_VALUE;
      for(int k=1;k<=f;k++) {
         int temp = 1 + Math.max(solve(e-1, k-1), solve(e, f-k));
         min=Math.min(min, temp);
      }
      t[e][f]=min;
      return min;
   }
   // public void display
   public static void main(String[] args) {
      EggDroppingProblem obj = new EggDroppingProblem();
      System.out.println(obj.solve(3, 5));
      obj.display(t);
   }
}
