import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] tgt, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tgt = new int[N];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tgt[i] = Integer.parseInt(st.nextToken());
        }
        int div = 0;
        int sub = 0;
        for (int i = 0; i < N; i++) {
            int num = tgt[i];
            int tempDiv = 0;
            int tempSub = 0;

            while (num > 0){
                if(num % 2 == 0) {
                    tempDiv++;
                    num /= 2;
                }
                else {
                    tempSub++;
                    num--;
                }
            }

            div = Math.max(div, tempDiv);
            sub += tempSub;
        }
        System.out.println(div + sub);
    }
}