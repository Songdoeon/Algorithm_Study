import java.util.*;
import java.io.*;

class Main{
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[10_001];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int floor1 = Integer.parseInt(st.nextToken());
            int floor2 = Integer.parseInt(st.nextToken());
            arr[floor1] = arr[floor2] = i;
            list.add(floor1);
            list.add(floor2);
        }
        Collections.sort(list);
        int f = N % (2 * M);
        System.out.println(f == 0 ? arr[list.get(2 * M - 1)] : arr[list.get(f - 1)]);
    }
}