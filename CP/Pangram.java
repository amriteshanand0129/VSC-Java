// 26th August
class Pangram {
    public static void missingPanagram(String s) {
        boolean alphabets[] = new boolean[26];
        for(int i=0; i<s.length(); i++) 
            alphabets[s.charAt(i) - 'a'] = true;
        
        for(int i=0; i<26; i++) {
            if(!alphabets[i])
                System.out.print((char)('a' + i) + " ");
        }
    }
    public static void main(String args[]) {
        String s = "dhkjfnwelkrfweojfklcw";
        System.out.println("Following are the missing characters required to make the string pangram: ");
        missingPanagram(s);
    }
}