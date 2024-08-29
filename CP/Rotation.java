public class Rotation {
    public static void reverse(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }
    public static void printArrary(int[] arr) {
        for(int i: arr) 
            System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length, k = 3;
        System.out.println("Original Array: ");
        printArrary(arr);
        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        System.out.println("\nRotated Array: ");
        printArrary(arr);
    }
}
