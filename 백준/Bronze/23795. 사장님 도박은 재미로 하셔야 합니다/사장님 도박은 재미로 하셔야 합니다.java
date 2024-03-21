import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int sum = 0;
        while(!(line = br.readLine()).equals("-1")){
            sum += Integer.parseInt(line);
        }
        System.out.println(sum);
    }
}