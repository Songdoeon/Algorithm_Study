import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String word;
        while(N-- > 0){
            word = br.readLine();
            if(word.length() < M) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o1) == map.get(o2) ?
                                o1.length() == o2.length() ?
                                o1.compareTo(o2) :
                                o2.length() - o1.length():
                                map.get(o2) - map.get(o1));
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}
