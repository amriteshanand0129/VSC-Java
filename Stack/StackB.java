import java.util.*;
import java.util.LinkedList;
public class StackB {

    // Implementing Stack using two Queue

    // First way
    // Push -> O(1)
    // Pop -> O(n)
    static class Stack1 {

        static Queue<Integer> q1 = new java.util.LinkedList<>();
        static Queue<Integer> q2 = new java.util.LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // Push
        public static void push(int data) {
            if(!q1.isEmpty())
                q1.add(data);
            else
                q2.add(data);
        }

        // Pop
        public static int pop() {

            if(isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty())
                        return top;
                    q2.add(top);
                }
            }
            else {
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty())
                        return top;
                    q1.add(top);
                }
            }
            return top;
        }

        // Peek
        public static int peek() {

            if(isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }

            int top = -1;
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
                return top;
            }
            else {
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
                return top;
            }
        }
    }

    // Second way
    // Push -> O(n)
    // Pop -> O(1)
    static class Stack2 {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }        

        // Push 
        public void push(int data) {

            if(!q1.isEmpty()) {
                q2.add(data);
                while(!q1.isEmpty()) 
                    q2.add(q1.remove());
            }

            else {
                q1.add(data);
                while(!q2.isEmpty())
                    q1.add(q2.remove());
            }
        }

        // Pop 
        public static int pop() {

            if(isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            if(!q1.isEmpty())
                return q1.remove();

            else    
                return q2.remove();
        }

        // Peek
        public static int peek() {

            if(isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            if(!q1.isEmpty())
                return q1.peek();

            else    
                return q2.peek();
        }
    }

    public static void main(String args[]) {

        // Push -> O(1)
        // Pop -> O(n)
        System.out.println("\nStack 1 - Pushing in O(1) and Pop in O(n)");
        // Stack1 s1 = new Stack1();
        // s1.push(1);
        // s1.push(2);
        // s1.push(3);
        // while(!s1.isEmpty()) 
        //     System.out.println(s1.pop());
        
        // Push -> O(n)
        // Pop -> O(1)
        System.out.println("\nStack 2 - Pushing in O(n) and Pop in O(1)");
        // Stack2 s2 = new Stack2();
        // s2.push(5);
        // s2.push(6);
        // s2.push(7);
        // while(!s2.isEmpty())
        //     System.out.println(s2.pop());
    }
}
