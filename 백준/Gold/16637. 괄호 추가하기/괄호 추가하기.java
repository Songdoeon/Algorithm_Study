import java.io.*;
import java.util.*;
class Main {
    static int N, number;
    static int[] numbers;
    static char[] ops;
    static int[] result;
    static int ans = -100_000_000;
    static int calc(int pre, int num, int odx){
        char c = ops[odx];
        if(c == '+') pre += num;
        else if(c == '-') pre -= num;
        else pre *= num;

        return pre;
    }
    static void search(int depth, int idx, int num){
        if(depth >= number) {
            if(depth == number) num = calc(num, numbers[depth], idx);
            ans = Math.max(ans, num);
            return ;
        }
        search(depth+1, idx + 1, calc(num, numbers[depth], idx));
        search(depth+2, idx + 2, calc(num, result[depth], idx));

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        if(N == 1){
            System.out.println(br.readLine());
            return ;
        }
        number = N / 2;
        numbers = new int[number + 1];
        result = new int[number];
        ops = new char[number];

        String exec = br.readLine();
        numbers[0] = exec.charAt(0) - '0';
        ops[0] = exec.charAt(1);
        int nIdx = 1;
        int oIdx = 1;
        int rIdx = 0;
        for (int i = 2; i < N; i++) {
            if(i % 2 == 0) {
                numbers[nIdx++] = exec.charAt(i) - '0';
                char c = ops[oIdx - 1];
                if(c == '+') result[rIdx++] = numbers[nIdx - 1] + numbers[nIdx - 2];
                else if(c == '-') result[rIdx++] = (numbers[nIdx - 1] * -1) + numbers[nIdx - 2];
                else result[rIdx++] = numbers[nIdx - 1] * numbers[nIdx - 2];
            }
            else ops[oIdx++] = exec.charAt(i);
        }
        search(1, 0, numbers[0]);
        search(2, 1, result[0]);
        System.out.println(ans);
    }
}