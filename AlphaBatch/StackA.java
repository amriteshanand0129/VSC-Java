import java.util.*;

public class StackA {

    // Implementing Stack using ArrayLists

    static class Stack {

        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {

            if(isEmpty())
                return -1;
            
            int index = list.size() - 1;

            int top = list.get(index);
            list.remove(index);

            return top;
        }

        // peek
        public static int peek() {

            if(isEmpty())
                return -1;

            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {

        /*  The methods can be accessed directly using the class name.
                OR
            Object can be created of the static class to access the methods -> although compiler will give warning
            Only one object should be created.
            No mean of creating multiple objects as data will remain same in all due to static.

            If class is accessed directly first using the class name and then objects are created then 
            the data fed using direct access will be visible to the later objects as well, due to static.

            Both ways has been demostrated below

            For detail on static class, can refer geeksforgeeks
        */

        
        
        // Object 
        {
            Stack S1 = new Stack();
            S1.push(10);
            S1.push(20);
            S1.push(30);

            while(!S1.isEmpty()) {
                System.out.println(S1.peek());
                S1.pop();
            }
        }

        // Direct Access
        {
            Stack.push(1);
            Stack.push(2);
            Stack.push(3);
            
            while(!Stack.isEmpty()) {
                System.out.println(Stack.peek());
                Stack.pop();
            }
        }
    }
}