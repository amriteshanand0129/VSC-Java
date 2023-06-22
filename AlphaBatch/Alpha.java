public class Alpha {

    // Checking for sorted array using recursion

    // static int checkorder(int arr[], int i) {
    //     if(i < arr.length-1){
    //         if(arr[i] <= arr[i+1]) {
    //             return(checkorder(arr, i+1));
    //         }
    //         else {
    //             return(0);
    //         }
    //     }
    //     return(1);
    // }
    // public static void main(String args[]) {
    //     Scanner in = new Scanner(System.in);
    //     in.close();
    //     int arr[] = {4, 4, 3, 5};
    //     System.out.println(arr.length);
    //     int check = checkorder(arr, 0);
    //     if(check == 1) {
    //         System.out.println("Sorted");
    //     }
    //     else {
    //         System.out.println("Not Sorted");
    //     }
    // }

    // Finding the first index of an element in an array using recursion

    // static int firstindex(int arr[], int i, int n) {
    //     if(arr[i] == n) {
    //         System.out.println(i);
    //         return i;
    //     }
    //     if(i == (arr.length-1)) {
    //         return -1;
    //     }
    //     return(firstindex(arr, i+1, n));
    // }
    // public static void main(String args[]) {
    //     int arr[] = {4, 1, 8, 2, 6, 8, 5, 9};
    //     int index = firstindex(arr, 0, 9);
    //     System.out.println(index);
    //     if(index != -1) {
    //         System.out.println("Found at: " + index);
    //     }
    //     else {
    //         System.out.println("Not found");
    //     }
    // }

    // Finding the last occurence of any element in an array

    static int lastindex(int arr[], int i, int n) {
        if(i == arr.length-1){
            return -1;
        }
        int r = lastindex(arr, i+1, n);
        if(r == -1 && arr[i] == n) {
            return i;
        }
        else if(r != -1) {
            return r;
        }
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {1, 3, 5, 7, 9, 3, 5, 7};
        System.out.println(lastindex(arr, 0, 3));
    }

    
}
