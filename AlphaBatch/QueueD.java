import java.util.*;
public class QueueD {

    // Implementing Queue using two Stacks

    // First way
    // Add -> O(n)
    // Remove/Peek -> O(1)
    static class Queue_1 {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Add
        public static void add(int data) {

            while(!s1.isEmpty()) 
                s2.push(s1.pop());

            s1.push(data);

            while(!s2.isEmpty()) 
                s1.push(s2.pop()); 
        }

        // Remove 
        public static int remove() {

            if(s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.pop();
        }

        // Peek 
        public static int peek() {

            if(s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.peek();
        }
    }

    // Second way
    // Add -> O(1)
    // Remove/Peek -> O(n)
    static class Queue_2 {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Add
        public static void add(int data) {
            s1.push(data);
        }

        // Remove
        public static int remove() {

            if(s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            while(!s1.isEmpty()) 
                s2.push(s1.pop());

            int data = s2.pop();

            while(!s2.isEmpty()) 
                s1.push(s2.pop());

            return data;
        }

        // Peek
        public static int peek() {

            if(s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            while(!s1.isEmpty()) 
                s2.push(s1.pop());

            int data = s2.peek();

            while(!s2.isEmpty()) 
                s1.push(s2.pop());

            return data;
        }
    }
    public static void main(String args[]) {

        // Add -> O(n)
        // Remove/Peek -> O(1)
        System.out.println("Queue 1 - Adding in O(n) and Removing in O(1)");
        // Queue_1 q1 = new Queue_1();
        // q1.add(1);
        // q1.add(2);
        // q1.add(3);
        // q1.add(4);
        // while(!q1.isEmpty()) 
        //     System.out.println(q1.remove());

        // Add -> O(1)
        // Remove/Peek -> O(n)
        System.out.println("Queue 2 - Adding in O(1) and Removing in O(n)");
        // Queue_2 q2 = new Queue_2();
        // q2.add(1);
        // q2.add(3);
        // q2.add(5);
        // q2.add(7);
        // while(!q2.isEmpty()) 
        //     System.out.println(q2.remove());
    }
}