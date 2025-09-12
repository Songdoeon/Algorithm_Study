import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String s;
    static int N;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) set.add(br.readLine());
        int len = s.length();
        for (int i = 0; i < 26; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                char c = (char) ((s.charAt(j) + i) % ('z' + 1));
                sb.append(c < 'a' ? (char)(c + 'a') : c);
            }
            for(String word : set){
                if(sb.toString().contains(word)){
                    System.out.println(sb);
                    return ;
                }
            }
        }
    }
}
