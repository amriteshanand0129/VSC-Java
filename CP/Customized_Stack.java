// 29th August
import java.util.*;

public class Customized_Stack {
    /**
     * A stack implemented using Linked List, which enables access to the last,
     * first and the middle element
     */
    static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    static class Modified_Stack {
        Node head = null, tail = null, mid = null;
        int size = 0;

        public void push(int val) {
            Node node = new Node(val);
            size++;
            if (head == null) {
                head = node;
                tail = node;
                mid = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            if (size > 1 && size % 2 != 0)
                mid = mid.prev;
        }

        public void pop() {
            if (head == null)
                System.out.println("Empty Stack");
            size--;
            int val = head.val;
            head = head.next;
            if (size % 2 == 0)
                mid = mid.next;
            System.out.println("Popped: " + val);
        }

        public void getMid() {
            if (this.mid == null)
                System.out.println("Empty Stack");
            else
                System.out.println("Middle element: " + mid.val);
        }

        public void getLast() {
            if (head == null)
                System.out.println("Empty Stack");
            else
                System.out.println("Last element: " + head.val);
        }

        public void getFirst() {
            if (tail == null)
                System.out.println("Empty Stack");
            else
                System.out.println("First element: " + tail.val);
        }

        public void printStack() {
            Node node = head;
            System.out.print("Stack: [");
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println("\b]");
        }
    }

    public static void main(String args[]) {
        Modified_Stack stack = new Modified_Stack();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter command");
        String action = in.next(); int val;
        outer: while (!action.equals("exit")) {
            switch (action) {
                case "push":
                    val = in.nextInt();
                    stack.push(val);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "getmid":
                    stack.getMid();
                    break;
                case "getfirst":
                    stack.getFirst();
                    break;
                case "getlast":
                    stack.getLast();
                    break;
                case "print":
                    stack.printStack();
                    break;
                case "exit":
                    break outer;
                default:
                    break;
            }
            action = in.next();
        }
        in.close();
    }
}
