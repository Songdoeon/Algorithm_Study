import java.io.*;
import java.time.LocalDate;
import java.util.*;


class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LocalDate date = LocalDate.of(N, 1, 1);
        System.out.println(date.isLeapYear() ? 1 : 0);

    }
}