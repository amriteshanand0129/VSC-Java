package Trie;
public class Trie {

    // The solution for the Word Break Problem is not correct
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<26; i++) 
                children[i] = null;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {

        // T.C -> O(L) where L is length of the largest string
        Node curr = root;
        for(int level = 0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null)
                curr.children[idx] = new Node();
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {

        // T.C -> O(L) where L is length of the largest string
        Node curr = root;
        for(int level = 0; level<key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        
        if(key.length() == 0)
            return true;

        // Loop has been initialized with 1 to length to ease the property of substring function of excluding the end index
        System.out.println("Key: " + key);
        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0, i)) && wordBreak(key.substring(i)))
                return true;
        }

        return false;
    }
    public static void main(String args[]) {

        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for(String i: words)
        //     insert(i);
        // System.out.println(search("thee"));
        // System.out.println(search("thor"));

        System.out.println("\nWord Break Problem\n");
        String arr[] = {"i", "like", "sam", "samsumg", "mobile", "ice"};
        for(int i=0; i<arr.length; i++) 
            insert(arr[i]);
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
