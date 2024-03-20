import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = IntStream.rangeClosed(666, 2_700_000)
                .mapToObj(String::valueOf)
                .filter(s -> s.contains("666"))
                .toArray(String[]::new);

        System.out.println(arr[n - 1]);
    }
}
