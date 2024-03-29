import java.io.*;
import java.util.*;
public class Main {

    static int[] pi;
    static String parent, pattern;
    static int len1, len2;
    static void makePi(String p){
        int len = p.length();
        int idx = 0;
        for (int i = 1; i < len; i++) {
            while (idx > 0 && p.charAt(i) != p.charAt(idx))
                idx = pi[idx - 1];

            if(p.charAt(i) == p.charAt(idx))
                pi[i] = ++idx;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        parent = br.readLine();
        pattern = br.readLine();

        len1 = parent.length();
        len2 = pattern.length();
        pi = new int[len2];

        makePi(pattern);
        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < len1; i++) {
            while (idx > 0 && parent.charAt(i) != pattern.charAt(idx))
                idx = pi[idx - 1];
            if(parent.charAt(i) == pattern.charAt(idx))
                if(idx == len2 - 1){
                    cnt++;
                    sb.append(i - idx + 1).append(' ');
                    idx = pi[idx];
                }
                else idx++;
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}