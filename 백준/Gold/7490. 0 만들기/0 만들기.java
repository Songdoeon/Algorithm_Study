import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, N;
    static char[] oper = new char[9];
    static StringBuilder sb = new StringBuilder();
    static void search(int depth, int sum, int num, int op){
        if(depth == N){
            if(sum + (num * op)== 0){
                for (int i = 1; i < N; i++) {
                    sb.append(i).append(oper[i]);
                }
                sb.append(N);
                sb.append('\n');
            }
            return ;
        }
        oper[depth] = ' ';
        search(depth + 1, sum, (num * 10) + depth + 1, op);
        oper[depth] = '+';
        search(depth + 1, sum + (num * op), depth + 1, 1);
        oper[depth] = '-';
        search(depth + 1, sum + (num * op), depth + 1, -1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            search(1, 0, 1, 1);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
