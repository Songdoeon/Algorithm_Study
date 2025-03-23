import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int N;
    static char[] arr;
    static int count(char c, int start, int end, int op){
        int result = 0;
        boolean cluster = true;
        int idx = start;
        while ((idx += op) != end){
            if(arr[idx] != arr[start])cluster = false;
            if(!cluster && arr[idx] == c) result++;
        }

        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        
        int ans = Math.min(Math.min(count('R', 0, N, 1), count('B', 0, N, 1)),
                Math.min(count('R', N - 1, -1, -1), count('B', N - 1, -1, -1)));

        System.out.println(ans);
    }
}