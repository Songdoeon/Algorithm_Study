import java.io.*;
import java.util.*;

public class Main
{
    static int N, M, L, C;
    static int[] src, arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        src = new int[M+2];
        arr = new int[L];
        for(int i=1; i<=M; i++) {
            src[i] = Integer.parseInt(br.readLine());
        }
        src[0] = 0;
        src[M+1] = L;

        for(int i=0; i<N; i++) {
            C = Integer.parseInt(br.readLine());
            int lt = 1;
            int rt = L;
            int answer = 0;
            while(lt<rt){
                int mid = (lt+rt)/2;
                int count = canDivide(mid);
                if(count <= C){
                    rt = mid;
                }else{
                    lt = mid + 1;
                }
            }
            sb.append(rt - 1).append("\n");
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(sb);
        br.close();
    }
    public static int canDivide(int target) {
        int count = 0;
        int last = 0;
        for(int i=1; i<=M+1; i++) {
            if(src[i] - src[last] >= target) {
                count++;
                last = i;
            }
        }
        arr[target] = count;
        return count;
    }
}