// 29th August
import java.util.*;
class Anagram {
    public static boolean checkAnagram(String a, String b) {
        /**
         * T.C => O(n)
         * S.C => O(1)
         */
        if(a.length() != b.length())
            return false;
        int[] alphabets_a = new int[26];
        int[] alphabets_b = new int[26];
        for(int i=0; i<a.length(); i++)
            alphabets_a[a.charAt(i)-'a']++;
        for(int i=0; i<b.length(); i++)
            alphabets_b[b.charAt(i)-'a']++;
        for(int i=0; i<26; i++)
            if(alphabets_a[i] != alphabets_b[i])
                return false;
        return true;
    }

    public static int minDeletions(String a, String b) {
        /**
         * T.C => O(n + m)         because now the length of both the strings can be different
         * S.C => O(1)
         */
        int count = 0;
        int[] alphabets_a = new int[26];
        int[] alphabets_b = new int[26];
        for(int i=0; i<a.length(); i++)
            alphabets_a[a.charAt(i)-'a']++;
        for(int i=0; i<b.length(); i++)
            alphabets_b[b.charAt(i)-'a']++;
        for(int i=0; i<26; i++)
            count += Math.abs(alphabets_a[i] - alphabets_b[i]);
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String a = in.nextLine();
        System.out.print("Enter second String: ");
        String b = in.nextLine();
        in.close();

        boolean isAnagram = checkAnagram(a, b);
        if(isAnagram)
            System.out.printf("The strings %s and %s are Anagrams", a, b);
        else {
            System.out.printf("The strings %s and %s are not Anagrams", a, b);
            System.out.println("\nMinimum number of deletions required: " + minDeletions(a, b));
        }
    }
}