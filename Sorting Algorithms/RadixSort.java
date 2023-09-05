import java.util.Arrays;

public class RadixSort {

    public int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public void radixSort(int[] arr) {
        int max = getMax(arr);
        int maxDigits = (int) Math.floor(Math.log10(max)) + 1;
        for (int i = 1; i <= maxDigits; i++) {
            performSort(arr, i, arr.length);
        }
    }

    private void performSort(int[] arr, int digit, int n) {
        int frequency[] = new int[10];
        Arrays.fill(frequency, 0);
        int base = (int) Math.pow(10, digit);
        for (int i = 0; i < n; i++) {
            frequency[(arr[i] / (base / 10)) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            frequency[i] += frequency[i - 1];
        }
        int output[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[frequency[(arr[i] / (base / 10)) % 10] - 1] = arr[i];
            frequency[(arr[i] / (base / 10)) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    
    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RadixSort obj = new RadixSort();
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        System.out.println("Before Sorting");
        obj.printArray(arr);
        System.out.println();
        obj.radixSort(arr);
        System.out.println("After Sorting");
        obj.printArray(arr);
    }
}
