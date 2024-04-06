import java.util.*;
import java.io.*;
class Main{
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int idx1 = 0;
        int idx2 = 1;
        int idx3 = N - 1;

        int cnt = N;
        for (int i = 0; i < N; i++) {
            int exec = Integer.parseInt(st.nextToken());
            if(exec == 1){
                while (arr[idx1] != 0){
                    idx1++;
                }
                arr[idx1++] = cnt--;
                idx2++;
            }
            else if(exec == 2){
                if(idx2 <= idx1){
                    idx2 = idx1 + 1;
                }
                while (arr[idx2] != 0){
                    idx2++;
                }
                arr[idx2++] = cnt--;
            }
            else{
                while (arr[idx3] != 0){
                    idx3--;
                }
                arr[idx3--] = cnt--;
            }

        }
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}
