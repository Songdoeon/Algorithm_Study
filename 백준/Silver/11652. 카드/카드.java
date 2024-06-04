import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        int max = 0;
        while (N-- > 0){
            String num = br.readLine();
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) == max){
                if(Long.parseLong(num) < Long.parseLong(ans)){
                    ans = num;
                }
            }
            else if (map.get(num) > max){
                ans = num;
                max = map.get(num);
            }
        }
        System.out.println(ans);
    }
}
