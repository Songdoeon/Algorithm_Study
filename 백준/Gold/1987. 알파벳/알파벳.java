import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int R;
    static int C;

    static int answer;

    static Queue<int[]> queue = new LinkedList<>();
    static Set<Character> set = new HashSet<>();
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    static char[][] board;

    static boolean outOfMap(int x, int y){
        if(x < 0 || x >= R || y < 0 || y >= C) return true;
        return false;
    }
    static void search(int x, int y, int depth){
        char c = board[x][y];
        if(set.contains(c)) {
            answer = Math.max(answer, depth);
            return ;
        }
        set.add(c);
        for(int i = 0; i < 4; i++){
            int nX = x + dX[i];
            int nY = y + dY[i];
            if(outOfMap(nX, nY)) continue;
            search(nX, nY, depth + 1);
        }
        set.remove(c);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        answer = 1;
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                board[i][j] = line.charAt(j);
            }
        }
        search(0, 0, 0);

        System.out.println(answer);
    }
}