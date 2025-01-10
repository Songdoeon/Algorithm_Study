import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Village{
    int idx, count;

    public Village(int idx, int count) {
        this.idx = idx;
        this.count = count;
    }
}
public class Main {
    static int N;
    static Village[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new Village[N];
        long total = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            total += count;
            arr[i] = new Village(idx, count);
        }

        Arrays.sort(arr, (o1, o2) -> o1.idx - o2.idx);

        int s = 0;
        int e = N - 1;
        long flag = (total + 1) / 2;
        long sum = 0;
        while (s < e){
            sum += arr[s].count;
            if(sum >= flag) break;
            s++;
        }
        System.out.println(arr[s].idx);
    }
}