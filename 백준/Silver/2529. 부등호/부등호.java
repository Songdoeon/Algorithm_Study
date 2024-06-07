import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] numbers;
    static char[] arr;
    static boolean[] visited;
    static ArrayList<String> answer = new ArrayList<>();

    static void search(int start, int cnt, String word) {
        if (word.length() == N) { //부등호의 모든 조건을 달성하면 종료
            answer.add(word);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(visited[i]) continue;
            char tmp = arr[cnt];
            if (tmp == '>') {
                if (start > i) {
                    visited[i] = true;
                    search(i, cnt + 1, word + i);
                    visited[i] = false;
                }
            } else {
                if (start < i) {
                    visited[i] = true;
                    search(i, cnt + 1, word + i);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) + 1;
        arr = new char[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }
        for (int i = 0; i < 10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            search(i, 0, i+"");
            visited[i] = false;
        }
        System.out.println(answer.get(answer.size()-1) + "\n" + answer.get(0));
    }
}