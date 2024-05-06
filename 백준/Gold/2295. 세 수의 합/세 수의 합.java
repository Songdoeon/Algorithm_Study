import java.util.*;
import java.io.*;


class Main {
    static int N;
    static int[] arr;
    static BitSet set = new BitSet(400_000_001);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = 0; j <= i; j++) {
                set.set(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if(set.get(arr[i] - arr[j])){
                    System.out.println(arr[i]);
                    return ;
                }
            }
        }
    }
}
