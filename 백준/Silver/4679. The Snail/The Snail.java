import java.time.*;
import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        float height, up, down, per;

        while (true){
            String[] arg = br.readLine().split(" ");
            if(arg[0].equals("0")) break;
            height = Integer.parseInt(arg[0]);
            up = Integer.parseInt(arg[1]);
            down = Integer.parseInt(arg[2]);
            per = up * (Float.parseFloat(arg[3]) / 100);
            int day = 0;
            float now = 0;
            while (true){
                if(now < 0)break;
                day++;
                now += up;
                if(now > height) break;
                now -= down;
                up -= per;
                if(up < 0)up = 0;
            }
            if(now <= 0) sb.append("failure on day ").append(day).append('\n');
            else sb.append("success on day ").append(day).append('\n');
        }
        System.out.println(sb);
    }
}