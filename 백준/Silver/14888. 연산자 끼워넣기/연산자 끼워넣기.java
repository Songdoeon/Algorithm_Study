import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16198

public class Main {
    static int N;
    static int[] arr, op;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static void search(int depth, int total){
        if(depth == N) {
            min = Math.min(min, total);
            max = Math.max(max, total);
            return ;
        }

        for(int i = 0; i < 4; i++){
            if(op[i] <= 0) continue;
            op[i]--;
            switch(i){
                case 0: search(depth + 1, total + arr[depth]); break;
                case 1: search(depth + 1, total - arr[depth]); break;
                case 2: search(depth + 1, total * arr[depth]); break;
                case 3: search(depth + 1, total / arr[depth]); break;
            }
            op[i]++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        op = new int[4];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        search(1, arr[0]);

        System.out.println(max + "\n" + min);
    }
}
