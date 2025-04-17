import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int T, N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int trash = 0;
            int ans = 0;
            int dis = 0;
            int weight = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                dis = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                if(trash + weight < M){
                    trash += weight;
                }
                else{
                    if(trash + weight == M){
                        ans += dis * 2;
                        trash = 0;
                    }
                    else {
                        trash = weight;
                        ans += dis * 2;
                    }
                }
            }
            if(trash > 0) {
                ans += dis * 2;
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
