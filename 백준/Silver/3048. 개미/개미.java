import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Ant{
    char c;
    int dir;

    public Ant(char c, int dir) {
        this.c = c;
        this.dir = dir;
    }
}
public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Ant[] arr = new Ant[N + M];
        StringBuilder str = new StringBuilder(br.readLine());
        str = str.reverse();
        for (int i = 0; i < N; i++) {
            arr[i] = new Ant(str.charAt(i), 1);
        }
        String s = str.toString();
        s += br.readLine();
        for (int i = N; i < N + M; i++) {
            arr[i] = new Ant(s.charAt(i), -1);
        }
        int time = Integer.parseInt(br.readLine());
        while (time-- > 0){
            for (int i = 0; i < N + M - 1; i++) {
                if(arr[i].dir == 1 && arr[i + 1].dir == -1){
                    Ant temp = new Ant(arr[i].c, arr[i].dir);
                    arr[i] = new Ant(arr[i + 1].c, arr[i + 1].dir);
                    arr[i + 1] = temp;
                    i++;
                }
            }
        }
        for (int i = 0; i < N + M; i++) {
            sb.append(arr[i].c);
        }
        System.out.print(sb);
    }
}