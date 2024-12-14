import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        char[] c = {'U','O','S'};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(c[(Integer.parseInt(br.readLine()) - 1) % 3]);
    }
}