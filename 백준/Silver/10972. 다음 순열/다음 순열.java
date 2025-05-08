import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버부수기

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = N - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            System.out.println(-1);
            return;
        }

        int j = N - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        int left = i + 1, right = N - 1;
        while (left < right) {
            tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int v : arr) {
            sb.append(v).append(' ');
        }
        System.out.println(sb);
    }
}
// 1 2 3 4, 1 2 4 3, 1 3 2 4, 1 3 4 2,