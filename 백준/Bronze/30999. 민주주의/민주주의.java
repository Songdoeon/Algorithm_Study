import java.io.*;
import java.util.StringTokenizer;

class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int len = br.readLine().replace("X","").length();
            if(len > M / 2) ans++;
        }
        System.out.println(ans);
    }
}