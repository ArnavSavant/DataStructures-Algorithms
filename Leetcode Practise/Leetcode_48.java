public class Leetcode_48 {
   public void rotate(int[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;
      for(int i=0;i<m;i++) {
         for(int j = i;j<n;j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
         }
      }

      for(int i=0;i<m;i++) {
         int start = 0;
         int end = n-1;
         while(start<=end) {
            int temp = matrix[i][start];
            matrix[i][start] = matrix[i][end];
            matrix[i][end] = temp;
            start++;
            end--;
         }
      }
   }
}
