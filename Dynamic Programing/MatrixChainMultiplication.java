public class MatrixChainMultiplication {
   int t[][] = new int[1001][1001];
   public void initialize() {
      for(int i=0;i<1001;i++) {
         for(int j=0;j<1001;j++) {
            t[i][j]=-1;
         }
      }
   }
   public int solve(int arr[], int i, int j) { //genral format to tackle MCM
      if(i>=j) { // base condition => size can't zero or one
         return 0;
      }
      if(t[i][j] != -1) {
         return t[i][j];
      }
//option 1
//    0  1	2	3	4
//    10	40	30	10	20
// 	   i			j
// 	   k	k	k		i <= k <= j-1
//    i to k & k+1 to j

//option 2
//    0  1	2	3	4
//    10	40	30	10	20
// 	   i			j
// 		   k	k	k	i+1 <= k <= j
//    i to k-1 & k to j
      int minCost=Integer.MAX_VALUE;
      for(int k=i;k<=j-1;k++) {
         int temp=solve(arr, i, k)+solve(arr, k+1, j)+(arr[i-1]*arr[k]*arr[j]);
         minCost=Math.min(minCost, temp);
      }
      t[i][j]=minCost;
      return minCost;
   }
   public static void main(String[] args) {
      MatrixChainMultiplication obj = new MatrixChainMultiplication();
      int arr[]= {40,10,30,10,20};
      obj.initialize();
      System.out.println(obj.solve(arr, 1, arr.length-1));
   }
}
