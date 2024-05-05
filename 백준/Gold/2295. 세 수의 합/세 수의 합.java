import java.util.*;
import java.io.*;


class Main {
    static int N;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        int result = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        boolean find = false;

        for (int i = 0; i < N - 1; i++) {
            int n1 = arr[i];
            for (int j = i + 1; j < N; j++) {
                int n2 = arr[j];
                int start = j;
                int end = N - 1;
                while (start <= end){
                    int sum = arr[start] + arr[end];
                    if(n1 == n2 + sum) {
                        find = true;
                        result = n1;
                    }
                    if(n1 < n2 + sum){
                        start++;
                    }
                    else end--;
                }
            }
            if(find) break;
        }
        System.out.println(result);
    }
}
