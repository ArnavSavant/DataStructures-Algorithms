import java.util.PriorityQueue;

public class SortNearlySortedArray {
    public void solve(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int i = 0;
        for (int x : arr) {
            minHeap.add(x);
            if (minHeap.size() > k) {
                arr[i] = minHeap.poll();
                i++;
            }
        }
        while (minHeap.size() > 0) {
            arr[i] = minHeap.poll();
            i++;
        }
    }

    public void printArray(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SortNearlySortedArray obj = new SortNearlySortedArray();
        int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
        obj.printArray(arr);
        obj.solve(arr, 4);
        obj.printArray(arr);
    }
}
