public class ImplementQueueUsingArray {
    class Queue {
        int front, rear;
        int[] arr;

        Queue() {
            front = -1;
            rear = -1;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            rear++;
            arr[rear] = e;
            if (front == -1) {
                front = 0;
            }
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if (front == -1 || front > rear) {
                return -1;
            }
            return arr[front++];
        }
    }
}
