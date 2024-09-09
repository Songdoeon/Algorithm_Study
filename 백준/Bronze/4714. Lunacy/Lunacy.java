import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double ans = 0;
        while(true){
            ans = Double.parseDouble(br.readLine());
            if(ans < 0){
                break;
            }
            double m = ans * 0.167;
            System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", ans, m);
        }
    }
}