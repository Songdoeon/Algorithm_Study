import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ans = "";
        if(n >= 620) ans = "Red";
        else if(n >= 590) ans = "Orange";
        else if(n >= 570) ans = "Yellow";
        else if(n >= 495) ans = "Green";
        else if(n >= 450) ans = "Blue";
        else if(n >= 425) ans = "Indigo";
        else if(n >= 380) ans = "Violet";
        System.out.println(ans);
    }
}
