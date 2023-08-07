public class NextAlphabeticalElement {
   public char search(char arr[], char x) {
      int low = 0;
      int high = arr.length-1;
      char res='~';
      while(low<=high) {
         int mid = low + (high-low)/2;
         if(arr[mid]==x) {
            return x;
         }
         else if((int)arr[mid] > (int)x) {
            high = mid-1;
         }
         else if((int)arr[mid] < (int)x) {
            low = mid+1;
         }
         if((int)arr[mid] > (int)x) {
            res=(char)Math.min((int)res,(int)arr[mid]);
         }
      }
      return res;
   }
   public static void main(String[] args) {
      NextAlphabeticalElement obj = new NextAlphabeticalElement();
      char arr[]={'a','b','g','i','m','o','s','w','z'};
      System.out.println(obj.search(arr, 'o'));
   }
}
