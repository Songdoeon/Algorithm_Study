import java.io.*;
import java.util.*;

class Person{
    String name;
    int days;

    public Person(String line) {
        String[] info = line.split(" ");
        name = info[0];
        days = Integer.parseInt(info[1]);
        days += Integer.parseInt(info[2]) * 30;
        days += Integer.parseInt(info[3]) * 365;
    }
}
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Person> list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new Person(br.readLine()));
        }
        list.sort(Comparator.comparingInt(o -> o.days));

        System.out.println(list.get(N - 1).name + "\n" + list.get(0).name);
    }
}