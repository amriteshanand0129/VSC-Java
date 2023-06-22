public class Recursion_Ques {

    // Question 1

    public static void keyIndex(int arr[], int key, int index) {
        if(arr[index] == key)
            System.out.println(index+1);
        if(index == arr.length-1)
            return;
        keyIndex(arr, key, index+1);
        return;
    }

    // Question 2

    public static String number_word(String words[], int num, String s) {
        int dig = num % 10;
        if(dig == 0) 
            return s;
        s = words[dig] +" "+ s;
        return number_word(words, num/10, s);
    }

    // Question 3

    public static int length_string(String s, int l) {
        if(s == "")
            return l;
        return length_string(s.substring(1), l+1);
    }

    // Question 4

    public static int substring(String s, int startindex, int endindex, int count) {
        if(startindex == s.length()) 
            return count;
        if(endindex == s.length())
            return substring(s, startindex+1, startindex+1, count);
        else { 
            if(s.charAt(startindex) == s.charAt(endindex))
                count += 1;  
            return substring(s, startindex, endindex+1, count);
        }
    }
    
    public static void main(String args[]) {

        // Find the indices of given key in the array

        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        keyIndex(arr, 2, 0);

        // Convert digits to words

        String words[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int number = 1947;
        System.out.println(number_word(words, number, ""));

        // Find length of the string

        String s = "Lovely Professional University";
        System.out.println(length_string(s, 0));

        // Find contiguous substrings starting and ending with same character
        
        String s1 = "abcdef";
        System.out.println(substring(s1, 0, 0, 0));
    }
}
