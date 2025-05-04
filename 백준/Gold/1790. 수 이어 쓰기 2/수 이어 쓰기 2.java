import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1790 - 08:40 시작

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int idx = 1;
        long op = 9;
        long start = 1;
        while (M > idx * op){
            M -= idx * op;
            idx++;
            op *= 10;
            start *= 10;
        }

        long offset = (M - 1) / idx;
        long target = start + offset;

        if(N < target){
            System.out.println(-1);
        }
        else System.out.println(String.valueOf(target).charAt((M - 1) % idx));
    }
}

