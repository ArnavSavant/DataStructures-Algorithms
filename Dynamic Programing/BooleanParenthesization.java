public class BooleanParenthesization {
   // int t[][][]=new int[1001][1001][2]; 
   public int solve(char arr[], int i, int j, boolean isTrue) {
      int ans = 0;
      if (i > j) { //means array is empty
         return 0;
      }
      if (i == j) { //signifies there is only a single character present i.e 'T' or 'F'
         if (isTrue == true) {
            return arr[i] == 'T' ? 1 : 0;
         } 
         else {
            return arr[i] == 'F' ? 1 : 0;
         }
      }
      int lT,rT,lF,rF;
      for (int k = i+1; k <= j - 1; k=k+2) {
         lT=solve(arr, i, k-1, true);
         lF=solve(arr, i, k-1, false);
         rT=solve(arr, k+1, j, true);
         rF=solve(arr, k+1, j, false);
         if(arr[k]=='&') {
            if (isTrue == true) {
               ans=ans+(lT*rT);
            } 
            else {
               ans=ans+(lT*rF)+(rT*lF)+(lF*rF);
            }
         }
         if(arr[k]=='|') {
            if (isTrue == true) {
               ans=ans+(lT*rT)+(lT*rF)+(lF*rT);
            } 
            else {
               ans=ans+(lF*rF);
            }
         }
         if(arr[k]=='^') {
            if (isTrue == true) {
               ans=ans+(lF*rT)+(lT*rF);
            } 
            else {
               ans=ans+(lT*rT)+(lF*rF);
            }
         }
      }
      return ans;
   }
   public static void main(String[] args) {
      BooleanParenthesization obj = new BooleanParenthesization();
      // char arr[]={'T','^','F','&','T'};
      char arr[]={'T','|','T','&','F','^','T'};
      System.out.println(obj.solve(arr, 0, arr.length-1, true));
   }
}
