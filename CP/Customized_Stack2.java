// 9th September

import java.util.*;
public class Customized_Stack2 {
    static int index1, index2, size, mid;
    static int[] arr;

    public static void push1(int num) {
        if (index1 >= mid) {
            System.out.println("Cannot push to Stack 1");
            return;
        }
        arr[++index1] = num;
    }

    public static void push2(int num) {
        if (index2 <= (mid+1)) {
            System.out.println("Cannot push to Stack 2");
            return;
        }
        arr[--index2] = num;
    }

    public static void pop1() {
        if (index1 < 0) {
            System.out.println("Cannot pop from Stack 1");
            return;
        }
        System.out.println(arr[index1--]);
    }

    public static void pop2() {
        if (index2 >= size) {
            System.out.println("Cannot pop form Stack 2");
            return;
        }
        System.out.println(arr[index2++]);
    }

    public static void printArray() {
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        size = 10; mid = size / 2 - 1;
        arr = new int[size];
        Arrays.fill(arr, -1);
        index1 = -1; index2 = size;
        String input = in.next();
        while (!input.equals("exit")) {
            switch (input) {
                case "push1":
                    push1(in.nextInt());
                    break;
                case "push2":
                    push2(in.nextInt());
                    break;
                case "pop1":
                    pop1();
                    break;
                case "pop2":
                    pop2();
                    break;
                case "print":
                    printArray();
                    break;
                default:
                    break;
            }
            input = in.next();
        }
        in.close();
    }
}
