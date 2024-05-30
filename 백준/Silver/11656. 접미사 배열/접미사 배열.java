import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        int len = word.length();
        String[] words = new String[len];
        for (int i = 0; i < len; i++) {
            words[i] = word.substring(i);
        }
        Arrays.sort(words);
        for (int i = 0; i < len; i++) {
            bw.write(words[i]);
            bw.write('\n');
        }
        bw.flush();
    }
}
