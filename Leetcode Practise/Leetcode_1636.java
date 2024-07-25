import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_1636 {
    class Pair {
        int value;
        int freq;

        Pair(int v, int f) {
            this.value = v;
            this.freq = f;
        }
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        System.out.println(mp);
        Pair arr[] = new Pair[mp.size()];
        int ind = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            arr[ind] = new Pair(entry.getKey(), entry.getValue());
            ind++;
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.freq == b.freq) {
                    return Integer.compare(b.value, a.value);
                }
                return Integer.compare(a.freq, b.freq);
            }
        });
        ind = 0;
        for (Pair p : arr) {
            int freq = p.freq;
            while (freq-- != 0) {
                nums[ind] = p.value;
                ind++;
            }
        }

        return nums;
    }

    public void display(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Leetcode_1636 obj = new Leetcode_1636();
        int nums[] = { 1, 1, 2, 2, 2, 3 };
        obj.display(obj.frequencySort(nums));
    }
}
