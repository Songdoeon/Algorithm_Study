import java.io.*;
import java.util.*;

public class Main {
//    static int N, M;
    static int[][] map = new int[9][9];
    static int[] changes;
    static StringBuilder sb = new StringBuilder();
    static int[] partition(int x, int y){
        if(x < 3){
            if(y < 3) return new int[] {0, 0};
            else if(y < 6) return new int[] {0, 3};
            return new int[] {0, 6};
        }
        else if(x < 6){
            if(y < 3) return new int[] {3, 0};
            else if(y < 6) return new int[] {3, 3};
            return new int[] {3, 6};
        }
        if(y < 3) return new int[] {6, 0};
        else if(y < 6) return new int[] {6, 3};
        return new int[] {6, 6};
    }
    static boolean colCheck(int num, int y){
        for (int i = 0; i < 9; i++) {
            if(map[i][y] == num) return false;
        }
        return true;
    }
    static boolean rowCheck(int num, int x){
        for (int i = 0; i < 9; i++) {
            if(map[x][i] == num) return false;
        }
        return true;
    }
    static boolean recCheck(int num, int[] pos){
        for (int i = pos[0]; i < pos[0] + 3; i++) {
            for (int j = pos[1]; j < pos[1] + 3; j++) {
                if(map[i][j] == num)return false;
             }
        }
        return true;
    }
    static void search(int x, int y){
        if(x == 9 && y == 0){
            for (int i = 1; i < 10; i++) {
                if(changes[i] != 0) return ;
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(y == 9){
            search(x + 1, 0);
            return ;
        }
        if(map[x][y] == 0){
            for (int i = 1; i <= 9; i++) {
                int[] p = partition(x, y);
                if(changes[i] == 0)continue;
                if(!colCheck(i, y) || !rowCheck(i, x) || !recCheck(i, p)) continue;
                map[x][y] = i;
                changes[i]--;
                search(x, y + 1);
                map[x][y] = 0;
                changes[i]++;
            }
        }
        else search(x, y + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        changes = new int[] {0, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                changes[map[i][j]]--;
            }
        }
        search(0, 0);
        System.out.println(sb);
    }
}