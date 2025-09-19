import java.io.*;
public class Main {
    static int N, len;
    static String s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = s.length();
        int len = 0;

        for (int i = 0; i < N; i++) if (s.charAt(i) == 'a') len++;

        if (len == 0 || len == N) {
            System.out.println(0);
            return;
        }


        int cnt = 0;
        for (int i = 0; i < len; i++) if (s.charAt(i) == 'b') cnt++;

        int ans = cnt;

        int idx = len;

        while(idx < len + N){
            if(s.charAt((idx - len) % N) == 'b') cnt--;
            if(s.charAt(idx % N) == 'b')cnt++;
            ans = Math.min(ans, cnt);
            idx++;
        }
        System.out.println(ans);
    }
}
