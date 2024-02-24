import java.io.*;
import java.util.*;
class Node{
    int no, weight;

    public Node(int no, int weight) {
        this.no = no;
        this.weight = weight;
    }
}
public class Main {
    static int T, N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[26];
        int result = 0;
        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            int len = s.length();
            for(int j = 1; j <= len ; j++){
                arr[s.charAt(j - 1) - 'A'] += (int) Math.pow(10, len - j);
            }
        }
        Arrays.sort(arr);
        int mul = 9;
        for (int i = 25; i > 15; i--) {
            result += arr[i] * mul--;
            if(mul == 0) break;
        }
        System.out.println(result);


    }
}
