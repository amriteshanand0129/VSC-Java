package TCS_CodeVita;
import java.util.*;

public class RajuConlang {

    static Scanner in = new Scanner(System.in);
    static HashMap<Integer, Integer> var = new HashMap<>();
    static int lineno = 0;

    public static void func_if(ArrayList<String> lines, String[] words) {
        String expression = words[1];
        char var1 = expression.charAt(0);
        char var2 = expression.charAt(expression.length()-1);

        Boolean condition = null;
        if(expression.length() == 4) {
            if(expression.charAt(1) == '=') {
                if(var.get((int)(var1)) == var.get((int)(var2)))
                    condition = true;
                else    
                    condition = false;
            }
            else {
                if(var.get((int)(var1)) != var.get((int)(var2)))
                    condition = true;
                else    
                    condition = false;
            }
        }
        else if(expression.length() == 3) {
            if(expression.charAt(1) == '>') {
                if(var.get((int)(var1)) > var.get((int)(var2)))
                    condition = true;
                else    
                    condition = false;
            }
            else {
                if(var.get((int)(var1)) < var.get((int)(var2)))
                    condition = true;
                else    
                    condition = false;
            }
        }
        lineno++;
        if(condition) {
            if(lines.get(lineno).equals("Yes")) {
                lineno++;
                while(lineno<lines.size()-2) {
                    if(lines.get(lineno).equals("si"))
                        return;
                    else if(lines.get(lineno).equals("No")) {
                        while(!lines.get(lineno).equals("si")) {
                            lineno++;
                        }
                        return;
                    }
                    String line = lines.get(lineno);
                    String tokens[] = line.split(" ");
                    if(tokens[0].equals("print"))
                        func_print(tokens);
                    else if(tokens[0].equals("is"))
                        func_if(lines, tokens);
                    lineno++;
                }
            }
        }
        else {
            outer: while(!lines.get(lineno).equals("No")) {
                if(lines.get(lineno).equals("si"))
                    break outer;
                lineno++;
            }
            lineno++;
            while(!lines.get(lineno).equals("si")) {
                String line = lines.get(lineno);
                String tokens[] = line.split(" ");
                if(tokens[0].equals("print"))
                    func_print(tokens);
                else if(tokens[0].equals("is"))
                    func_if(lines, tokens);
                lineno++;
            }
        }
    }
    public static void func_print(String[] words) {
        System.out.println(var.get((int)(words[1].charAt(0))));
    }
    public static void main(String args[]) {
        int i = 0;
        ArrayList<String> lines = new ArrayList<>();
        // while(in.hasNextLine()) 
        //     lines.add(in.nextLine());
        while(i++ < 12) 
            lines.add(in.nextLine());
        
        int l = lines.size();


        String variables[] = lines.get(l-2).split(" ");
        String values[] = lines.get(l-1).split(" ");
        i = 0;
        for(String variable: variables) 
            var.put((int)variable.charAt(0), Integer.parseInt(values[i++]));

        i = 0;
        while(lineno < lines.size()-2) {
            String line = lines.get(lineno);
            String words[] = line.split(" ");
            if(words[0].equals("is"))
                func_if(lines, words);
            else if(words[0].equals("print"))
                func_print(words);
            lineno++;
        }
    }
}
