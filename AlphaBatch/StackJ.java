import java.util.*;
public class StackJ {

    // Implementing Stack using Java Collections Framework
    public static void main(String args[]) {

        // // Pushing at bottom of stack
        // {
        //     Stack<Integer> s = new Stack<>();
        //     s.push(1);
        //     s.push(2);
        //     s.push(3);

        //     pushAtBottom(0, s);
        //     pushAtBottom(-1, s);

        //     System.out.println("\nStack after pushing at bottom ");
        //     while(!s.empty()) 
        //         System.out.println(s.pop());
        // }

        // // Reversing string using stack
        // {
        //     Stack<Character> revstack = new Stack<>();

        //     String word = "abcdefg";
        //     String revString = reverseString(revstack, word);

        //     System.out.println("\nOrginal String: " + word);
        //     System.out.println("Reversed String: " + revString);
        // }
    
        // // Reversing stack
        // {
        //     Stack<Integer> stack = new Stack<>();
        //     stack.push(10);
        //     stack.push(20);
        //     stack.push(30);
        //     stack.push(40);

        //     reverseStack(stack);

        //     System.out.println("\nReversed Stack -");
        //     while(!stack.empty()) 
        //         System.out.println(stack.pop());
        // }
    
        // // Stock Span Problem
        // {
        //     int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        //     int span[] = new int[stocks.length];
        //     stockSpan(stocks, span);
        //     System.out.println("Stock Span Array: ");
        //     for(int i=0; i<span.length; i++) {
        //         System.out.print(span[i] + " ");
        //     }
        // }
    
        // // Next Greater Element 
        // {
        //     int arr[] = {6, 8, 0, 1, 3};
        //     int nextGreater[] = new int[arr.length];
        //     nextGreater(arr, nextGreater);

        //     System.out.println("Next Greater Elements:");
        //     for(int i=0; i<nextGreater.length; i++) 
        //         System.out.println(nextGreater[i]);
        // }
    
        // // Valid Parentheses
        // {
        //     String parentheses = "({[]}()";
        //     System.out.println("Parentheses string is: " + parentheses);
        //     System.out.println("Validity of parentheses is: " + isValid(parentheses));
        // }
    
        // // Duplicate Parentheses
        // {
        //     String s = "((a + b)(c + d))";
        //     System.out.println("Prescence of duplicate parentheses: " + duplicate(s));
        // }
    
        // 
        int heights[] = {2, 4};
        Stack<Integer> leftindex = new Stack<>();
        Stack<Integer> rightindex = new Stack<>();
        int l = heights.length;
        int leftarr[] = new int[l];
        int rightarr[] = new int[l];
        for(int i=0; i<l; i++) {
            int level = heights[i];
            while(!leftindex.isEmpty() && heights[leftindex.peek()] >= level) 
                leftindex.pop();
            if(leftindex.isEmpty())
                leftarr[i] = i;
            else
                leftarr[i] = leftindex.peek();
            leftindex.push(i);
        }
        for(int i=l-1; i>=0; i--) {
            int level = heights[i];
            while(!rightindex.isEmpty() && heights[rightindex.peek()] >= level)
                rightindex.pop();
            if(rightindex.isEmpty())
                rightarr[i] = i;
            else
                rightarr[i] = rightindex.peek();
            rightindex.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<l; i++) {
            int h = heights[i];
            int area = (rightarr[i] - leftarr[i]) * h;
            max = Math.max(max, area);
        }
        System.out.println(max);
    }

    // Pushing at the bottom of stack using recursion
    public static void pushAtBottom(int data, Stack<Integer> s) {

        if(s.empty()) {
            s.push(data);
            return;
        }

        int value = s.pop();
        pushAtBottom(data, s);
        s.push(value);
    }

    // Reversing string using stack/recursion 
    public static String reverseString(Stack<Character> revstack, String word) {

        if(word == "") 
            return "";

        revstack.push(word.charAt(0));

        return reverseString(revstack, word.substring(1)) + revstack.pop();
    }

    // Reversing a stack without using extra space
    /* Time complexity = O(n)
       Space complexity = O(1) -> using recursion
       */
    public static void reverseStack(Stack<Integer> stack) {

        if(stack.empty()) 
            return;
        
        int val = stack.pop();

        reverseStack(stack);
        pushAtBottom(val, stack);
    }


    // Stock Span Problem using Stack
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;
        
        for(int i=1; i<stocks.length; i++) {

            while(!stack.isEmpty() && stocks[stack.peek()] <= stocks[i]) 
                stack.pop();

            if(stack.isEmpty()) 
                span[i] = i+1;

            else 
                span[i] = i - stack.peek();

            stack.push(i);
        }
    }


    // Next Greater Element
    public static void nextGreater(int arr[], int nextGreater[]) {
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) {
            int current = arr[i];
            while(!stack.isEmpty() && stack.peek() < current) 
                stack.pop();
            if(stack.isEmpty()) 
                nextGreater[i] = -1;
            else 
                nextGreater[i] = stack.peek();
            stack.push(current);
        }
    }

    // Valid Parentheses
    // public static boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<>();
    //     for(int i=0; i<s.length(); i++) {
    //         char ch = s.charAt(i);
    //         if(ch == '(') 
    //             stack.push(')');
    //         else if(ch == '{') 
    //             stack.push('}');
    //         else if(ch == '[')
    //             stack.push(']');
    //         else {
    //             if(stack.isEmpty() || ch != stack.pop())
    //                 return false;
    //         }       
    //     }
    //     if(stack.isEmpty())
    //         return true;
    //     return false;
    // }

    // Duplicate Parentheses
    public static boolean duplicate(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(')
                stack.push(')');
            else if (ch == ')') {
                if(stack.peek() == 'E') 
                    stack.pop();
                else    
                    return true;
                stack.pop();
            }
            else if(ch != ' '){
                if(stack.peek() != 'E')
                    stack.push('E');
            }
        }
        return false;
    }
}