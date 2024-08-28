import java.util.*;
public class practice3 {
    public static void queue(Stack<Integer> stack1, Stack<Integer> stack2, int num) {
        while(!stack1.isEmpty()) 
            stack2.push(stack1.pop());
        stack1.push(num);
        while(!stack2.isEmpty()) 
            stack1.push(stack2.pop());
    }
    public static int dequeue(Stack<Integer> stack) {
        return stack.pop();
    } 

    public static void main(String args[]) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2= new Stack<>();
        int i = 0;
        while(i < 10) 
            queue(stack1, stack2, i++);
        while(!stack1.isEmpty())  
            System.out.println(dequeue(stack1));      
    }
}
