import java.io.*;
import java.util.*;

public class Main {
    static String word, target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        int len = word.length();
        target = br.readLine();
        int targetLen = target.length();

        int cnt = targetLen - len;
        StringBuilder sb = new StringBuilder(target);
        sb.reverse();
        while (cnt-- > 0){
            if(sb.charAt(0) == 'A') sb = new StringBuilder(sb.substring(1));
            else {
                sb = new StringBuilder(sb.substring(1));
                sb.reverse();
            }
        }
        sb.reverse();
        if(sb.toString().equals(word)) System.out.println(1);
        else System.out.println(0);
    }
}