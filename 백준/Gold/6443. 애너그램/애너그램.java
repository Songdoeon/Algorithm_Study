import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static int N, len;
    static int[] chars;
    static char[] selected;
    static Set<String> set;
    static StringBuilder sb = new StringBuilder();

    static void check(int depth) {
        if(depth == len){
            String str = String.valueOf(selected);
            if(set.contains(str))return ;
            set.add(str);
            return ;
        }

        for (int i = 0; i < 26; i++) {
            if(chars[i] == 0) continue;
            selected[depth] = (char) (i + 'a');
            chars[i]--;
            check(depth + 1);
            chars[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            len = str.length();
            chars = new int[26];
            for (int j = 0; j < len; j++) {
                        char c = str.charAt(j);
                chars[c - 'a']++;
            }
            selected = new char[len];
            set = new TreeSet<>();
            check(0);
            for(String s : set){
                sb.append(s).append('\n');
            }
        }

        System.out.println(sb);
    }
}
