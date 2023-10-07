public class QueueB {

    // Implementing Queue using Linked List
    // Node Class
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void add(int data) {

            Node newnode = new Node(data);

            if(head == null)  // Adding first element
                head = tail = newnode;

            tail.next = newnode;
            tail = newnode;
        }

        public static int remove() {

            if(isEmpty()) { // Empty Queue
                System.out.println("Queue is Empty");
                return -1;
            }

            int front = head.data;
            
            if(tail == head) // Single element left to be removed
                tail = head = null;
            else
                head = head.next;

            return front;
        }
        public static int peek() {

            if(isEmpty()) { // Empty Queue
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String args[]) {

        // Queue using Linked List
        System.out.println("Queue -");
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);

        // while(!q.isEmpty()) { // Printing the Queue
        //     System.out.println(q.peek());
        //     q.remove();
        // }
    }
}
