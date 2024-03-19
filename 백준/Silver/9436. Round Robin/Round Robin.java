import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int[] arr;
    static int N, T;

    static boolean check(int n){
        int no = arr[0];
        for (int i = 1; i < n; i++) {
            if(no != arr[i])return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            String[] arg = br.readLine().split(" ");
            if(arg[0].equals("0"))break;
            N = Integer.parseInt(arg[0]);
            T = Integer.parseInt(arg[1]);

            arr = new int[N];
            int idx = 0;
            while (N > 1){
                for (int i = 0; i < T; i++) {
                    if(i == 0 && idx == 0) {
                        arr[0]++;
                        idx++;
                    }
                    else arr[idx++ % N]++;
                }
                int index = idx % N;

                if(index == 0) {
                    System.arraycopy(arr, index, arr, index, N - index);
                    idx = N;
                }
                else{
                    System.arraycopy(arr, index, arr, index - 1, N - index);
                    idx = index - 1 ;
                }
                N--;
                if(check(N)) break;
            }
            sb.append(N).append(" ").append(arr[0]).append('\n');
        }
        System.out.println(sb);
    }

}