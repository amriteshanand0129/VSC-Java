import java.util.LinkedList;
class Deque {
    
    // Stack using Deque
    static class Stack {
        java.util.Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    // Queue using Deque
    static class Queue {
        java.util.Deque<Integer> deque = new LinkedList<>();

        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.getFirst();
        }
    }
    public static void main(String args[]) {

        // Deque using JCF
        // java.util.Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(1);
        // deque.addFirst(2);
        // System.out.println(deque);
        // deque.removeFirst();
        // System.out.println(deque);
        // deque.addLast(2);
        // deque.addLast(3);
        // System.out.println(deque);
        // System.out.println("First element = " + deque.getFirst());

        // Stack using Deque
        System.out.println("\nStack using Deque -");
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Peek = " + s.peek());
        System.out.print(s.pop() + " ");
        System.out.print(s.pop() + " ");
        System.out.print(s.pop() + " ");

        // Queue using Deque
        System.out.println("\n\nQueue using Deque - ");
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.print(q.remove() + " ");
        System.out.print(q.remove() + " ");
        System.out.print(q.remove() + " ");
    }
}