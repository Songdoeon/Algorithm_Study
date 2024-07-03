import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(0 + " " + 1);
            return ;
        }
        if(N == 2){
            System.out.println(1 + " " + 1);
            return ;
        }
        int[] arr = new int[N];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i < N; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[N - 2] + " " + arr[N - 1]);
    }
}