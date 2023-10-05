import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMissingNumbers {
    public List<Integer> findMissingIntegers(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
        for (int x : arr2) {
            mp.put(x, true);
        }
        for (int x : arr1) {
            if (!mp.containsKey(x)) {
                ans.add(x);
            }
        }
        return ans;
    }

    public void printArray(int arr[]) {
        for (int x : arr) {
            System.out.print(x + "  ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        FindMissingNumbers obj = new FindMissingNumbers();
        int arr1[] = { 1, 3, 5, 8, 9, 15, 18 };
        int arr2[] = { 3, 8, 9, 18 };
        System.out.println("Elements of ARRAY 1");
        obj.printArray(arr1);
        System.out.println("Elements of ARRAY 2");
        obj.printArray(arr2);
        System.out.println("Missing numbers are:");
        System.out.println(obj.findMissingIntegers(arr1, arr2));
    }
}