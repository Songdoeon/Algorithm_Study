import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arg = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(arg[0] >= arg[2]){
            System.out.println(1);
            return ;
        }
        int high = arg[0] - arg[1];
        double num = (double) (arg[2] - arg[0]) / high;
        double ceil = Math.ceil(num);
        double floor = Math.floor(num);
        if(floor == ceil) System.out.println(floor == 0 ? 2 : (int) floor + 1);
        else System.out.println((int) ceil + 1);
    }
}
