import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        int[] arr = new int[90_001];
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        boolean flag = false;
        for (int i = 1; i < 90_001; i++) {
            if(!flag && arr[i] != 0) {
                sum += i;
                flag = true;
            }
            else if(arr[i] == 0)flag = false;
        }
        System.out.println(sum);
    }
}