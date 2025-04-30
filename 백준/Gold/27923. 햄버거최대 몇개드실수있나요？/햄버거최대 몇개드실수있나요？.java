import java.io.*;
import java.util.*;

// 27923 : 11:35 시작

public class Main {
    static int N, K, L;
    static int[] coke, burgers, effects;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        burgers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) burgers[i] = Integer.parseInt(st.nextToken());
        
        coke = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            coke[Integer.parseInt(st.nextToken())]++;
        }

        effects = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            int c = coke[i];
            if (c == 0) continue;
            int end = Math.min(i + L, N + 1);
            effects[i] += c;
            effects[end] -= c;
        }
        for (int i = 1; i <= N; i++) effects[i] += effects[i - 1];

        int[] effList = new int[N];
        for (int i = 0; i < N; i++) effList[i] = effects[i+1];

        Arrays.sort(burgers); 
        Arrays.sort(effList); 
        
        long ans = 0;
        for (int i = 0; i < N; i++) {
            int v = burgers[i];
            int e = effList[i];
            ans += (long)(v / Math.pow(2, e));
        }

        System.out.println(ans);
    }
}
