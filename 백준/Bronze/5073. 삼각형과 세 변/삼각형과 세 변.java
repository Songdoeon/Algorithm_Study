import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        String str;
        while(!(str = br.readLine()).equals("0 0 0")){
            if(str == "0 0 0") System.out.println(str);
            int[] arg = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            if(arg[0] == arg[1] || arg[1] == arg[2] || arg[0] == arg[2]) answer = "Isosceles";
            else answer = "Scalene";
            if(arg[0] == arg[1] && arg[1] == arg[2]) answer = "Equilateral";
            
            Arrays.sort(arg);
            if(arg[0] + arg[1] <= arg[2]) answer = "Invalid";
            System.out.println(answer);
        }
    }

}