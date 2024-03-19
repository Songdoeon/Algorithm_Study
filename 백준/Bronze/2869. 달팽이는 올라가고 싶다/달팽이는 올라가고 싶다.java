import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        
        int high = A - B;
        int floor = (N - A) / high;
        if((N - A) % high != 0){
            System.out.println(floor == 0 ? 2 : floor + 2);
        }
        else System.out.println(floor + 1);
    }
}
