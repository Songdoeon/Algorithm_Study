import java.io.*;
import java.util.*;

public class Main {
    static int N, number;
    static String line;
    static char[] ops;
    static int[] numbers;
    static int[][] max, min;
    static int calc(int pre, int num, char op){
        if(op == '+') return pre + num;
        else if(op == '-') return pre - num;
        return pre * num;
    }

    static int search(int s, int e){
        if(max[s][e] != Integer.MIN_VALUE) return max[s][e];

        if(s == e) return max[s][e] = min[s][e] = numbers[s];

        for(int idx = s; idx < e; idx++){
            int[] l = {search(s, idx),  min[s][idx]};
            int[] r = {search(idx + 1, e), min[idx + 1][e]};

            for (int left : l) {
                for (int right : r){
                    int num = calc(left, right, ops[idx]);
                    max[s][e] = Math.max(max[s][e], num);
                    min[s][e] = Math.min(min[s][e], num);
                }
            }
        }
        return max[s][e];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        number = N / 2 + 1;
        numbers = new int[number];
        ops = new char[number - 1];
        line = br.readLine();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) numbers[i / 2] = line.charAt(i) - '0';
            else ops[i / 2] = line.charAt(i);
        }

        max = new int[number][number];
        min = new int[number][number];

        for (int i = 0; i < number; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        System.out.println(search(0, number - 1));
    }
}
