import java.io.*;
import java.util.*;

class Class{
    int start, end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Class[] arr = new Class[N];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Class(start, end);
            ends[i] = end;
        }
        Arrays.sort(arr, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
        Arrays.sort(ends);
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if(ends[idx] <= arr[i].start) {
                idx++;
            }
        }
        System.out.println(N - idx);
    }
}
