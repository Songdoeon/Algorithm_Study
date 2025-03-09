import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Member{
    int min, max;

    public Member(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
public class Main {
    static int N, P, E;
    static Member[] arr;
    static int[] selected;
    static int[] answer;
    static void search(int depth, int cnt){
//        System.out.println(depth + " : " + cnt);
        if(cnt == P){
//            System.out.println(Arrays.toString(selected));
            int minSum = 0;
            int maxSum = 0;
            int tempMax = E;
            for(int i = 0; i < P; i++){
                minSum += arr[selected[i]].min;
                maxSum += arr[selected[i]].max;
            }
            if(minSum <= E && E <= maxSum){
                for (int i = 0; i < P; i++) {
                    answer[selected[i]] += arr[selected[i]].min;
                }
                tempMax -= minSum;
                for (int i = 0; i < P; i++) {
                    int num = tempMax - (arr[selected[i]].max - arr[selected[i]].min);
                    if(num >= 0){
                        int diff = (arr[selected[i]].max - arr[selected[i]].min);
                        answer[selected[i]] += diff;
                        tempMax -= diff;
                    }
                    else {
                        answer[selected[i]] += tempMax;
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    sb.append(answer[i]).append(' ');
                }
                System.out.println(sb);
                System.exit(0);
            }
        }
        else {
            for (int i = depth; i < N; i++){
                selected[cnt] = i;
                search(i + 1, cnt + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        E  = Integer.parseInt(st.nextToken());
        selected = new int[P];
        arr = new Member[N];
        answer = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Member(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        search(0, 0);
        System.out.println(-1);
    }
}
