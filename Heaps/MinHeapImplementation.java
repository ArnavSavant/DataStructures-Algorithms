public class MinHeapImplementation {

    static class MinHeap {
        int heap[];
        int length;
        MinHeap(int size) {
            heap = new int[size];
            length = 0;
        }

        void minHeapify(int heap[], int pos) {
            int ind = pos;
            while ((2 * ind + 1) < length) {
                int smallest = ind;
                int leftChild = 2 * smallest + 1;
                int rightChild = 2 * smallest + 2;

                if (heap[leftChild] < heap[smallest]) {
                    smallest = leftChild;
                }
                if (((2 * ind + 2) < length) && heap[rightChild] < heap[smallest]) {
                    smallest = rightChild;
                }

                if (smallest != ind) {
                    int temp = heap[smallest];
                    heap[smallest] = heap[ind];
                    heap[ind] = temp;
                    ind = smallest;
                } else {
                    break;
                }
            }
        }

        // Implement the function to remove minimum element.
        int extractMinElement() {
            if (length == 0) {
                return -1;
            }
            int min = heap[0];
            if (length == 1) {
                heap[0] = 0;
            } else {
                heap[0] = heap[length - 1];
                minHeapify(heap, 0);
            }
            length--;
            return min;
        }

        // Implement the function to delete an element.
        void deleteElement(int ind) {
            heap[ind] = heap[length - 1];
            length--;
            minHeapify(heap, ind);
        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            if (length == heap.length) {
                return;
            }
            int i = length;
            heap[i] = val;
            length++;
            while (i > 0 && heap[i] < heap[i / 2]) {
                int temp = heap[i];
                heap[i] = heap[i / 2];
                heap[i / 2] = temp;
                i = i / 2;

            }
        }
    }
};