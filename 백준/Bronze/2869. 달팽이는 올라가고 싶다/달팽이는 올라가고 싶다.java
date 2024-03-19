import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arg = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int high = arg[0] - arg[1];
        int floor = (arg[2] - arg[0]) / high;
        if((arg[2] - arg[0]) % high != 0){
            System.out.println(floor == 0 ? 2 : floor + 2);
        }
        else System.out.println(floor + 1);
    }
}
