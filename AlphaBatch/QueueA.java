public class QueueA {

    // Implementing Queue using Array
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        // Constructor
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }
        
        // Adding element at rear
        public static void add(int data) {

            if(rear == size-1) {
                System.out.println("Queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        // Removing front element
        public static int remove() {

            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = arr[0];
            for(int i=0; i<rear; i++) 
                arr[i] = arr[i+1];
            rear--;

            return front;
        }

        // Peeking front element
        public static int peek() {

            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[0];
        }

        public static void print() {
            int i = 0;
            while(i <= rear) {
                System.out.println(arr[i]);
                i++;
            }
        }
    }

    // Implementing Circular Queue using Array
    static class CircularQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear+1) % size == front;
        }

        public static void add(int data) {
            if(isFull()) {
                System.out.println("queue is full");
                return;
            }

            // Adding first element
            if(front == -1)
                front = 0;
            
            // Adding element at rear
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Removing element at front
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            int result = arr[front];

            if(rear == front) // If only single last element is left
                rear = front = -1;
            else
                front = (front+1) % size;
            return result;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return arr[front];
        }

    }
    // Main method
    public static void main(String args[]) {

        // Linear Queue
        System.out.println("Liner Queue -");
        // Queue q = new Queue(5);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // System.out.println("Queue is -");
        // q.print();

        // Circular Queue
        System.out.println("Circular Queue -");
        // CircularQueue cq = new CircularQueue(4);
        // cq.add(10);
        // cq.add(20);
        // cq.add(30);
        // cq.add(40); 
        // System.out.println("Removed element: " + cq.remove());
        // System.out.println("Removed element: " + cq.remove());
        // cq.add(50);
        // cq.add(60); 
        // System.out.println("Removed element: " + cq.remove());        
        // cq.add(70);
        // System.out.println("Circular Queue is -");
        // while(!cq.isEmpty()) {
        //     System.out.println(cq.peek());
        //     cq.remove();
        // }
    }
}