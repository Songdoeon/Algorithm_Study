import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = Map.of("Poblano", 1500, "Mirasol", 6000, "Serrano", 15500,
                "Cayenne", 40000, "Thai", 75000, "Habanero", 125000);

        int sum = 0;
        while (N-- > 0){
            sum += map.get(br.readLine());
        }
        System.out.println(sum);
    }
}