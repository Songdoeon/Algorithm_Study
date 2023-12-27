import java.util.*;
import java.io.*;
 
class Solution{
    static int power;
    static int size;
    static int[][] arr;
    static boolean outOfMap(int x, int y){
        if(x < 0 || x >= size || y < 0 || y >= size) return true;
        return false;
    }
    static int searchMul(int x, int y, int p){
        int sum = 0;
        if(x-p >= 0 && y + p < size)sum += arr[x - p][y + p];
        if(x+p < size && y - p >= 0)sum += arr[x + p][y - p];
        if(x-p >= 0 && y - p >= 0)sum += arr[x - p][y - p];
        if(x+p < size && y + p < size)sum += arr[x + p][y + p];    
        return sum;
    }
    static int searchPlus(int x, int y, int p){
        int sum = 0;
        if(x-p >= 0)sum += arr[x - p][y];
        if(x+p < size)sum += arr[x + p][y];
        if(y-p >= 0)sum += arr[x][y - p];
        if(y+p < size)sum += arr[x][y + p];    
        return sum;
    }
    static int check(int x, int y){
        int sumMul = arr[x][y];
        int sumPlus = arr[x][y];
        for(int j = 1; j < power; j++){
                sumPlus += searchPlus(x, y , j);
                sumMul += searchMul(x, y, j);
        }
        return Math.max(sumMul, sumPlus);
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = 0;
            size = info[0];
            power = info[1];
            arr = new int[size][size];
             
            for(int i = 0; i < size; i++){
                int[] tempArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                arr[i] = tempArr;
            }
             
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    max = Math.max(max, check(i, j));
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}