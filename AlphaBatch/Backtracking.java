public class Backtracking {

    // Changing the elements of array while backtracking
    public static void changeArray(int arr[], int index) {

        // base case
        if(index == arr.length) 
            return;

        // value initiation
        arr[index] = index+1;
        
        // recursion
        changeArray(arr, index+1);
        arr[index] -= 3;    // backtracking step
        return;
    }

    // Printing the subsets of a string
    public static void subsets(String s, int index, String newstr) {
        if(index == s.length()) {
            if(newstr.length() == 0)
                System.out.println("null");
            else
                System.out.println(newstr);
            return;
        }
        subsets(s, index+1, newstr);
        subsets(s, index+1, newstr+s.charAt(index));
    }

    // Finding and printing permutations of string
    public static void permutation(String s, String newstr) {
        // Base case
        // No need for index parameter in function as according to my own approach it is only needed for printing the newstring at the end of the stack 
        // But it can be done by checking the orginal string becoming null 
        if(s.length()==0) {
            System.out.println(newstr);
            return;
        }
        for(int i=0; i<s.length(); i++) {
            permutation(s.substring(0, i)+s.substring(i+1, s.length()), newstr+s.charAt(i));
        }
    }
    public static void main(String args[]) {

        // Changing elements of array while backtracking
        int arr[] = new int[5];
        changeArray(arr, 0);
        for(int i=0; i<arr.length; i++) 
            System.out.print(arr[i] + "  ");
        
        // Printing subsets of a string
        System.out.println("\nSubsets of the string are: ");
        String str = "abc";
        subsets(str, 0, "");

        // Printing permutation of string
        System.out.println("\nPermutations of string are: ");
        String str2 = "abcd";
        permutation(str2, "");
    }
}
