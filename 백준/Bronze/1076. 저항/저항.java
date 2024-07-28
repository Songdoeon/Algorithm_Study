import java.io.*;
import java.util.*;
class Woom{
    String sum;
    int value;

    public Woom(String sum, int value) {
        this.sum = sum;
        this.value = value;
    }
}
class Main {
    static int N;
    static String word;
    static int len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Woom> map = new HashMap<>();
        map.put("black", new Woom("0", 1));
        map.put("brown", new Woom("1", 10));
        map.put("red", new Woom("2", 100));
        map.put("orange", new Woom("3", 1000));
        map.put("yellow", new Woom("4", 10000));
        map.put("green", new Woom("5", 100000));
        map.put("blue", new Woom("6", 1000000));
        map.put("violet", new Woom("7", 10000000));
        map.put("grey", new Woom("8", 100000000));
        map.put("white", new Woom("9", 1000000000));
        System.out.println((long) Integer.parseInt(
                map.get(br.readLine()).sum + map.get(br.readLine()).sum) * map.get(br.readLine()).value);
    }
}
