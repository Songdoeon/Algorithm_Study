import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        for (char c : arr) sb.append(c);
        System.out.println(sb.reverse());
    }
}
