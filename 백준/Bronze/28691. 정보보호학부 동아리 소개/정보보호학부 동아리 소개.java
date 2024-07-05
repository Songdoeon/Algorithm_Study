import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ans = "";
        if(str.equals("M")) ans = "MatKor";
        else if(str.equals("W")) ans = "WiCys";
        else if(str.equals("C")) ans = "CyKor";
        else if(str.equals("A")) ans = "AlKor";
        else if(str.equals("$")) ans = "$clear";
        System.out.println(ans);
    }
}