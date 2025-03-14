import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int T, N, len;
    static char[] word;
    static int[] cnt;
    static StringBuilder sb = new StringBuilder();
    static void search(){
        cnt = new int[26];
        ArrayDeque<Integer>[] index = new ArrayDeque[26];
        int length = len + 1;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if(++cnt[word[i] - 'a'] == 1){
                index[word[i] - 'a'] = new ArrayDeque<>();
            }
            index[word[i] - 'a'].add(i);
            if(cnt[word[i] - 'a'] >= N){
                int start = index[word[i] - 'a'].pollFirst();
                length = Math.min(length, i - start + 1);
                max = Math.max(max, i - start + 1);
            }
        }
        if(length == len + 1 && max == 0) sb.append(-1).append('\n');
        else sb.append(length).append(' ').append(max).append('\n');
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            word = br.readLine().toCharArray();
            N = Integer.parseInt(br.readLine());
            len = word.length;
            if(N == 1) sb.append(1).append(' ').append(1).append('\n');
            else search();
        }
        System.out.println(sb);
    }
}
