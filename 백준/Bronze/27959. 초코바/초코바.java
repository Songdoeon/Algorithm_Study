import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = br.readLine().split(" ");
        int n = Integer.parseInt(arg[0]);
        int m = Integer.parseInt(arg[1]);
        
        System.out.println(n*100 >= m ? "Yes" : "No");
    }
}