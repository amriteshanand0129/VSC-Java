import java.util.*;
import java.util.LinkedList;
public class Queue_Ques {

    // First Non Repeating Character in a stream of characters
    static void non_Repeating(String s) {

        Queue<Character> q = new LinkedList<>();
        char ch;
        int freq[] = new int[26];
        System.out.println("\nFirst non repeating characters at each stage: ");
        for(int i=0; i<s.length(); i++) {

            ch = s.charAt(i);
            freq[ch-'a']++;
            q.add(ch);

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1) 
                q.remove();

            if(q.isEmpty())
                System.out.print("-1 ");

            else    
                System.out.print(q.peek() + " ");
        }
    }

    static void printQueue(Queue<Integer> q) {
        while(!q.isEmpty())
            System.out.print(q.remove() + " ");
    }

    // Interleaving the elements of a Queue
    static void interleave(Queue<Integer> q) {

        Queue<Integer> q1 = new LinkedList<>(); // Queue to store first half of the original queue
        int mid = q.size() / 2;
        int count = 1;

        // Separating the first half of the Queue
        while(count <= mid) {
            q1.add(q.remove());
            count++;
        }   

        // Interleaving the queue
        while(!q1.isEmpty()) {
            q.add(q1.remove());
            q.add(q.remove());
        }

        System.out.println("\n\nInterleaved Queue -");
        printQueue(q);
    }

    static void reverse_Queue(Queue<Integer> q) {

        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty())
            s.push(q.remove());
        while(!s.isEmpty())
            q.add(s.pop());
        
        System.out.println("\n\nReversed Queue -");
        printQueue(q);
    }
    public static void main(String args[]) {

        // First non repeating character in stream of characters
        String s = "aabccxb";
        non_Repeating(s);

        // Interleaving the elements of Queue
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        q.add(11);
        q.add(12);
        interleave(q);

        // Queue Reversal
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        reverse_Queue(q1);
    }
}
