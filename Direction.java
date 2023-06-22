import java.util.*;
class Direction{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        //Compression of string

        System.out.println("Enter string to be compressed");
        String str = in.nextLine();
        in.close();
        StringBuilder sb = new StringBuilder();
        int l = str.length();
        for(int i=0;i<l;i++){
            char ch = str.charAt(i);
            int count=1;
            int index = i+1;
            while(index<l){
                if(str.charAt(index)==ch){
                    count++;
                    index++;
                }
                else
                    break;
            }
            i = i+count-1;
            if(count==1)
                sb.append(ch);
            else{
                sb.append(ch);
                sb.append(count);
            }
        }
        System.out.println(sb);
    }
}

