import java.io.BufferedReader;
import java.io.InputStreamReader;

// 17609 : 17:20 시작

public class Main {
    static int N;

    static int check(String str){
        int len = str.length();
        int s = 0;
        int e = len - 1;
        while (s <= e){
            if(str.charAt(s) != str.charAt(e)) {
                int tempS = s + 1;
                int tempE = e;
                while (tempS <= tempE){
                    if(str.charAt(tempS) != str.charAt(tempE)) break;
                    tempS++;
                    tempE--;
                }
                if(tempS > tempE) return 1;
                tempS = s;
                tempE = e - 1;
                while (tempS <= tempE){
                    if(str.charAt(tempS) != str.charAt(tempE)) return 2;
                    tempS++;
                    tempE--;
                }
                return 1;
            }
            s++;
            e--;
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(check(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }
}

