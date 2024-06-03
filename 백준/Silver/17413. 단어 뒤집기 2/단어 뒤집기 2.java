import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String word = br.readLine();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) == ' ') {
                sb.append(temp.reverse());
                temp.setLength(0);
                sb.append(' ');
            }
            else if (word.charAt(i) == '<') {
                sb.append(temp.reverse());
                temp.setLength(0);
                while (i < len && word.charAt(i) != '>') {
                    sb.append(word.charAt(i++));
                }
                sb.append('>');
            }
            else {
                temp.append(word.charAt(i));
            }
        }
        sb.append(temp.reverse());
        System.out.println(sb);
    }
}
