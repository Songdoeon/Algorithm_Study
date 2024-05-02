import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println(sc.nextInt() + sc.nextInt());
        }
    }
}