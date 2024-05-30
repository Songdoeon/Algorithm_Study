import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();
        int len = word.length();
        String[] words = new String[len];
        for (int i = 0; i < len; i++) {
            words[i] = word.substring(i,len);
        }
        Arrays.sort(words);
        for (int i = 0; i < len; i++) {
            sb.append(words[i]).append('\n');
        }
        System.out.println(sb);
    }
}
