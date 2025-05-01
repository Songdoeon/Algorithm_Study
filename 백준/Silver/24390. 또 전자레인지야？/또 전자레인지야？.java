import java.io.BufferedReader;
import java.io.InputStreamReader;

// 15817 : 11:20 시작

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(":");
        N = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int ans = 0;

        ans += N / 600;
        N %= 600;


        ans += N / 60;
        N %= 60;

        if(N >= 30){
            ans--;
            ans += N / 30;
            N %= 30;
        }

        ans += N / 10;
        N %= 10;

        ans += N;
        ans++;
        System.out.println(ans);
    }
}

