// import java.util.*;
public class Recursion {

    // Optimised Power Calculation

    // public static int Poweroptimised(int a, int n) {
    //     if(n==1)
    //         return a;
    //     else
    //         if(n%2==0)
    //             return Poweroptimised(a, n/2) * Poweroptimised(a, n/2);
    //         else 
    //             return a * Poweroptimised(a, n/2) * Poweroptimised(a, n/2);
    // }
    // public static void main(String args[]) {
    //     Scanner in = new Scanner(System.in);
    //     int a = 2, b = 10;
    //     int answer = Poweroptimised(a, b);
    //     System.out.println(String.format("%d to the power %d is %d", a, b, answer));
    //     in.close();
    // }

    // Tiling Problem

    // public static int Tiling(int n) {
    //     if(n==0 || n==1) 
    //         return 1;
    //     // n-1 for vertical arrangement and n-2 for horizontal arrangement
    //     return Tiling(n-1) + Tiling(n-2);
    // }
    // public static void main(String args[]) {
    //     int ways = Tiling(4);
    //     System.out.println("Total number of ways possible is " + ways);
    // }

    // Removing duplicates from a string

    // public static StringBuilder Duplicate(String s, StringBuilder sb, int index, boolean arr[]) {
    //     if(index == s.length()) 
    //         return sb;
    //     if(arr[s.charAt(index) - 'a'] == false) {
    //         sb.append(s.charAt(index));
    //         arr[s.charAt(index) - 'a'] = true;
    //     }
    //     return Duplicate(s, sb, index+1, arr);
    // }
    // public static void main(String args[]) {
    //     String s = "rishurishu";
    //     StringBuilder sb = new StringBuilder();
    //     boolean arr[] = new boolean[26];
    //     StringBuilder newstr = Duplicate(s, sb, 0, arr);
    //     System.out.println(newstr);
    // }

    // Friends Pairing Problem

    // public static int FriendsPair(int n) {
    //     if(n==1 || n==2) 
    //         return n;
    //     // If anyone decides to stand in pair then he will have n-1 choices of people with whom he would like to stand in pair.
    //     return FriendsPair(n-1) + (n-1) * FriendsPair(n-2);
    // }
    // public static void main(String args[]) {
    //     int ways = FriendsPair(3);
    //     System.out.println("Total number of ways of pairing friends is "+ways);
    // }

    // Binary String problem

    // public static void BinaryString(int n, int a, StringBuilder sb) {
    //     if(n==0) 
    //         System.out.println(sb);
    //     else {
    //         BinaryString(n-1, 0, sb.append(0));
    //         if(a==0) {
    //             BinaryString(n-1, 1, sb.append(1));
    //         }
    //     }
    //     if(sb.length() > 0)
    //         sb.deleteCharAt(sb.length()-1);
    //     else 
    //         return;
    // }

    // // Instead of using StringBuilder we can use string to avoid deletion at end of each function call 
    // // We will not be adding any character to the actual string, rather just passing modified string to the next function

    // // BinaryString(n-1, 0, s+'0')
    // // BinaryString(n-1, 1, s+'1')

    // // In this case we need not delete character at the end of each function call
    // public static void main(String[] args) {
    //     StringBuilder sb = new StringBuilder();
    //     BinaryString(4, 0, sb);
    // }


}
