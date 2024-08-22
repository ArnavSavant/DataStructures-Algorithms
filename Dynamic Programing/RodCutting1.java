public class RodCutting1 {
   public int rodCutting(int l, int val[], int length[]) {
      int t[][] = new int[val.length+1][l+1];
      for(int i=0;i<=val.length;i++) {
         t[i][0]=0;
      }
      for(int i=0;i<=l;i++) {
         t[0][i]=0;
      }
      for(int i=1;i<=val.length;i++) {
         for(int j=1;j<=l;j++) {
            if(length[i-1]<=j) {
               t[i][j]=Math.max(t[i-1][j],val[i-1]+t[i][j-length[i-1]]);
            }
            else {
               t[i][j]=t[i-1][j];
            }
         }
      }
      return t[val.length][l];
   }
      //Recursive code
      // public int rodCutting(int l, int val[], int length[], int n) {
      //    if(n==0 || l == 0) {
      //       return 0;
      //    }
      //    if(length[n-1]>l) {
      //       return rodCutting(l, val, length, n-1);
      //    }
      //    return Math.max(val[n-1]+rodCutting(l-length[n-1], val, length,n),rodCutting(l, val, length, n-1));
      // }
   public static void main(String[] args) {
      RodCutting1 obj = new RodCutting1();
      int l=3;
      int length[]={1,2,3,4};
      int val[]={3,7,9,12};
      // System.out.println(obj.rodCutting(l, val, length,val.length));
      System.out.println(obj.rodCutting(l, val, length));
   }
}
