import java.util.*;
import java.io.*;

public class Main {
    static final int size = 10;
    static int ans = 101;
    static int[] papers = {0, 5, 5, 5, 5, 5};
    static int paper = 0;
    static int[][] map;
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= 10 || y < 0 || y >= 10;
    }
    static void undo(int x, int y, int size){
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = 1;
            }
        }
    }
    static void action(int x, int y, int size){
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = 0;
            }
        }
    }
    static boolean check(int x, int y, int size){
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(outOfMap(i, j)) return false;
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
    static void search(int x, int y, int sum){
        if(x == 10 && y == 0){
            ans = Math.min(sum, ans);
            return ;
        }
        if(ans <= sum) return ;
        if(y > 9) {
            search(x + 1, 0, sum);
            return ;
        }
        if(map[x][y] == 1){
            for (int i = 5; i >= 1; i--) {
                if(!check(x, y, i) || papers[i] == 0) continue;
                action(x, y, i);
                papers[i]--;
                search(x, y, sum + 1);
                undo(x, y, i);
                papers[i]++;
            }
        }
        else {
            search(x, y + 1, sum);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    paper++;
                }
            }
        }
        search(0, 0, 0);
        System.out.println(ans == 101 ? -1 : ans);
    }
}
