import java.io.*;
import java.util.*;

public class Main {
    static int[] win, lose, draw;
    static int[][] game;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        win = new int[6];
        lose = new int[6];
        draw = new int[6];

        game = new int[15][2];

        int idx = 0;
        StringTokenizer st;
        for(int i = 0;  i< 5; i++){
            for (int j = i + 1; j < 6; j++){
                game[idx][0] = j;
                game[idx][1] = i;
                idx++;
            }
        }

        for(int i = 0; i < 4; i++){
            result = false;
            int sum = 0;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 6; j++) {
                sum += win[j] = Integer.parseInt(st.nextToken());
                sum += draw[j] = Integer.parseInt(st.nextToken());
                sum += lose[j] = Integer.parseInt(st.nextToken());
            }

            if( sum != 30){
                sb.append("0 ");
                continue;
            }

            search(0);

            if(result)sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb);
    }

    static void search(int idx) {
        if(idx == 15){
            result = true;
            return ;
        }

        int teamA = game[idx][0];
        int teamB = game[idx][1];

        if(win[teamA] > 0 && lose[teamB] > 0){
            win[teamA] --;
            lose[teamB] --;

            search(idx + 1);

            win[teamA] ++;
            lose[teamB] ++;
        }

        if(win[teamB] > 0 && lose[teamA] > 0){
            win[teamB] --;
            lose[teamA] --;

            search(idx + 1);

            win[teamB] ++;
            lose[teamA] ++;
        }

        if(draw[teamB] > 0 && draw[teamA] > 0){
            draw[teamB] --;
            draw[teamA] --;

            search(idx + 1);

            draw[teamB] ++;
            draw[teamA] ++;
        }
    }
}
