import java.io.*;
import java.util.*;
class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.valueOf(br.readLine());
        int[] dx = new int[] {0,1,0,-1};
       	int[] dy = new int[] {1,0,-1,0};
		for(int test_case = 1; test_case <= T; test_case++){
			int size = Integer.valueOf(br.readLine());
            int[][] arr = new int [size][size];
            int index = 2;
            int dir = 0;
            int cX = 0;
            int cY = 0;
            arr[0][0] = 1;
			while(index <= size * size){
                cX += dx[dir % 4];
            	cY += dy[dir % 4];
                if(cX < 0 || cX >= size || cY < 0 || cY >= size || arr[cX][cY] != 0) {
                    cX -= dx[dir % 4];
                	cY -= dy[dir % 4];
                    dir++;
                    continue;
                }
                arr[cX][cY] = index++; 
            }
           	System.out.println("#" + test_case);
            for(int[] temp : arr){
                for(int num : temp){
                    System.out.print(num + " ");
                }
                System.out.println("");
            }
		}
	}
}