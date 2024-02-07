import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[101][101];
        int x, y;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for(int j = x; j < x + 10; j++){
                for (int k = y; k < y + 10; k++){
                    map[j][k] = 1;
                }
            }
        }
        int answer = (int) Arrays.stream(map).flatMapToInt(Arrays::stream).filter(n -> n == 1).count();

        System.out.println(answer);

    }
}
