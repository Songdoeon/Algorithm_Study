import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[] chars = new char[N];
        Arrays.fill(chars, 'B');
        int ret = 0;
        int cntA = 0;
        if(M == 0){
            chars[N - 1] = 'A';
        }
        else{
            for (int i = 0; i < N - 1; i++) {
                if(ret == M) break;
                int temp = ret + N - i - 1 - cntA;
//                System.out.println(ret + " : " + temp);
                if(temp <= M){
                    chars[i] = 'A';
                    ret += N - i - 1;
                    ret -= cntA++;
                }
            }
        }
        if(ret != M) System.out.println(-1);
        else System.out.println(String.valueOf(chars));
    }
}


