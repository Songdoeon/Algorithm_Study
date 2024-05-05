import java.util.*;
import java.io.*;


class Main {
    static int N;
    static Integer[] arr;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = 0; j <= i; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int n1 = arr[i];
            for (int j = i + 1; j < N; j++) {
                if(set.contains(n1 - arr[j])){
                    System.out.println(n1);
                    return ;
                }
            }
        }
    }
}
