package TCS_CodeVita;

import java.util.*;
public class SevenSegment {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String digit = in.nextLine();
        String side = in.nextLine();
        in.close();
        int l = digit.length();
        char a[] = new char[l];
        char b[] = new char[l];
        char c[] = new char[l];
        char d[] = new char[l];
        char e[] = new char[l];
        char f[] = new char[l];
        char g[] = new char[l];
        for(int i=0; i<l; i++) {
            char ch = digit.charAt(i);
            if(ch == '1') {
                g[i] = 'X'; d[i] = e[i] = f[i] = a[i] = ' ';
                b[i] = c[i] = '|';
            }
            else if(ch == '2') {
                f[i] = c[i] = ' ';
                b[i] = e[i] = '|';
                a[i] = g[i] = d[i] = '_';
            }
            else if(ch == '3') {
                f[i] = e[i] = ' ';
                b[i] = c[i] = '|';
                a[i] = g[i] = d[i] = '_';
            }
            else if(ch == '4') {
                a[i] = e[i] = d[i] = ' ';
                b[i] = c[i] = f[i] = '|';
                g[i] = '_';
            }
            else if(ch == '5') {
                b[i] = e[i] = ' ';
                c[i] = f[i] = '|';
                a[i] = d[i] = g[i] = '_';
            }
            else if(ch == '6') {
                b[i] = ' ';
                c[i] = e[i] = f[i] = '|';
                a[i] = d[i] = g[i] = '_';
            }
            else if(ch == '7') {
                d[i] = e[i] = f[i] = g[i] = ' ';
                b[i] = c[i] = '|';
                a[i] = '_';
            }
            else if(ch == '8') {
                b[i] = c[i] = e[i] = f[i] = '|';
                a[i] = d[i] = g[i] = '_';
            }
            else if(ch == '9') {
                e[i] = ' ';
                b[i] = c[i] = f[i] = '|';
                a[i] = d[i] = g[i] = '_';
            }
            else if(ch == '0') {
                g[i] = ' ';
                b[i] = c[i] = e[i] = f[i] = '|';
                a[i] = d[i] = '_';
            }
        }
        char temp;
        for(int i=0; i<l; i++) {
            char change = side.charAt(i);
            if(change == 'S')
                continue;
            else if(change == 'U' || change == 'D') {
                temp = e[i];
                e[i] = f[i];
                f[i] = temp;
                temp = b[i];
                b[i] = c[i];
                c[i] = temp;
                temp = a[i];
                a[i] = d[i];
                d[i] = temp;
            }
            else if(change == 'L'|| change == 'R') {
                temp = f[i];
                f[i] = b[i];
                b[i] = temp;
                temp = e[i];
                e[i] = c[i];
                c[i] = temp;
            }
        }
        for(int i=0; i<l; i++) {
            if(g[i] == 'X')
                System.out.print(" ");
            else if (b[i] == ' ' && c[i] == ' ')
                System.out.print(" "+ a[i]);
            else
                System.out.print(" " + a[i] + " ");
        }
        System.out.println();
        for(int i=0; i<l; i++) {
            if(g[i] == 'X') {
                if(f[i] == ' ')
                    System.out.print("" + b[i]);
                else
                    System.out.print("" + f[i]);
            }
            else {
                if(b[i] == ' ' && c[i] == ' ')
                    System.out.print("" + f[i] + g[i]);
                else
                    System.out.print("" + f[i] + g[i] + b[i]);
            }
        }
        System.out.println();
        for(int i=0; i<l; i++) {
            if(g[i] == 'X') {
                if(e[i] == ' ')
                    System.out.print("" + c[i]);
                else    
                    System.out.print("" + e[i]);
            }
            else {
                if(b[i] == ' ' && c[i] == ' ')
                    System.out.print("" + e[i] + d[i]);
                else
                    System.out.print(e[i] + "" + d[i] + c[i]);
            }
        }
    }
}