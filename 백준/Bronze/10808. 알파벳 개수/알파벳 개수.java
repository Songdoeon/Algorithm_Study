import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] cnt = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] ch = br.readLine().toCharArray();
        
        int len = ch.length;
        for(int i = 0; i < len; i++){
            cnt[ch[i] - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            sb.append(cnt[i]).append(' ');
        }
        System.out.println(sb);
    }
}