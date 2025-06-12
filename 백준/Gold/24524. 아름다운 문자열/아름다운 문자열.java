import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 24524

public class Main {
    static Queue<Integer>[] count = new Queue[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String target = br.readLine();
        int len = s.length();
        for (int i = 0; i < 26; i++) {
            count[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a'].offer(i);
        }
        len = target.length();
        boolean find = false;
        int ans = 0;
        while(true){
            int prev = -1;
            for (int i = 0; i < len; i++) {
                int idx = target.charAt(i) - 'a';
                while(!count[idx].isEmpty() && count[idx].peek() < prev){
                    count[idx].poll();
                }
                if(count[idx].isEmpty()){
                    find = true;
                    break;
                }
                prev = count[idx].poll();
            }
            if(find) break;
            ans++;
        }

        System.out.println(ans);
    }
}
