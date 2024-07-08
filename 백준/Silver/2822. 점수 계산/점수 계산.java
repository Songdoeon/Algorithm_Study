import java.io.*;
import java.util.*;
class Pos{
    int idx;
    int score;

    public Pos(int idx, int score) {
        this.idx = idx;
        this.score = score;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pos[] arr = new Pos[8];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 8; i++){
            arr[i - 1] = new Pos(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr, ((o1, o2) -> o2.score - o1.score));

        int sum = 0;
        int[] rank = new int[5];
        for(int i = 0; i < 5; i++){
            sum += arr[i].score;
            rank[i] = arr[i].idx;
        }
        Arrays.sort(rank);
        for (int i = 0; i < 5; i++) {
            sb.append(rank[i]).append(' ');
        }
        System.out.println(sum + "\n" + sb);
    }
}