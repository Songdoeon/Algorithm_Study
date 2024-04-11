import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = solution(arr);

        System.out.println(ans);
    }
    static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i=0; i < citations.length; i++){
            if(citations.length - i <= citations[i]){
                answer = citations.length - i;
                break;
            }
        }
        return answer;
    }
}