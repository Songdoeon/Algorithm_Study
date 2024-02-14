import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static String s;

    static boolean check(int size, int x, int y){
        int n = map[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++) {
                if(map[i][j] != n) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        String str;
        for(int i = 0; i < N; i++){
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(search(N, 0, 0));

    }

    static String search(int size, int x, int y) {
        
        if(check(size, x, y)){
            return map[x][y]+"";
        }

        size /= 2;

        String s1 = (search(size, x, y));
        String s2 = search(size, x , y+ size);
        String s3 = search(size, x+ size, y );
        String s4 = (search(size, x + size, y + size));

        return "("+s1 + s2 + s3 + s4+")";
    }
}

