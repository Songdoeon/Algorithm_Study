import java.io.*;

class Main{
    static int answer = 0;
    static void search(int[] arr,int depth, int n){
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;

            if (isPromising(depth, arr)){
                search(arr, depth + 1, n);
            }
        }
    }

    static boolean isPromising(int next, int[] row) {
        for (int i = 0; i < next; i++) {
            if (row[i] == row[next] || Math.abs(row[i]-row[next]) == next - i) return false;
        }
        return true;
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        search(arr, 0, N);
        System.out.println(answer);
    }
}