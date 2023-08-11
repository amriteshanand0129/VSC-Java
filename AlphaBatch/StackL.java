public class StackL {

    // Implementing Stack using LinkedLists
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Stack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;            
        }

        public static void push(int data) {
            
            Node newnode = new Node(data);

            if(isEmpty()) {
                head = newnode;
                return;
            }
        
            newnode.next = head;
            head = newnode;
        }

        public static int pop() {
            
            if(isEmpty() )
                return -1;

            int value = head.data;
            head = head.next;
            return value;
        }

        public static int peek() {

            if(isEmpty() )
                return -1;
            
            return head.data;

        }
    }
    public static void main(String args[]) {

        Stack S1 = new Stack();
            S1.push(10);
            S1.push(20);
            S1.push(30);

            while(!S1.isEmpty()) {
                System.out.println(S1.peek());
                S1.pop();
            }
    }
}
