import java.util.*;
class Solution {
    int[][] newBoard;
    int N, M;
    void operate() {
        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                newBoard[y][x] += newBoard[y - 1][x];
            }
        }
	
        for (int x = 1; x < M; x++) {
            for (int y = 0; y < N; y++) {
                newBoard[y][x] += newBoard[y][x - 1];
            }
        }
    }
    void cal(int x1, int y1, int x2, int y2, int degree){
        newBoard[x1][y1] += degree;
        newBoard[x2+1][y1] -= degree;
        newBoard[x1][y2+1] -= degree;
        newBoard[x2+1][y2+1] += degree;
        // for(int[] i : newBoard){
        //     for(int num : i){
        //         System.out.print(num + " ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("-------------");
    }
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        this.M = board.length;
        this.N = board[0].length;
        this.newBoard = new int[M + 1][N + 1];
        for(int[] info : skill){
            int x1 = info[1];
            int y1 = info[2];
            int x2 = info[3];
            int y2 = info[4];
            int degree = info[5];
            if(info[0] == 1) cal(x1, y1, x2, y2, -1 * degree);
            else cal(x1, y1, x2, y2, degree);
        }
        operate();
        // for(int[] i : newBoard){
        //     for(int num : i){
        //         System.out.print(num + " ");
        //     }
        //     System.out.println("");
        // }
        for(int x = 0; x < M; x++){
            for(int y = 0; y < N; y++){
                if(newBoard[x][y] + board[x][y] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}