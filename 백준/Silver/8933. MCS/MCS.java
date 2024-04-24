import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int[] cntArr;
    static Map<Long, Integer> map;
    static void add(){
//        String s = cntArr[0]+ "." + cntArr[6]+ "." + cntArr[19] + "." + cntArr[2];
        long result = cntArr[0];
        result = 601 * result + cntArr[6];
        result = 601 * result + cntArr[19];
        result = 601 * result + cntArr[2];
        map.put(result, map.getOrDefault(result, 0) + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            cntArr = new int[26];
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String DNA = st.nextToken();
            int len = DNA.length();
            for (int j = 0; j < n; j++) {
                cntArr[DNA.charAt(j) - 'A']++;
            }
            add();
            for (int j = n; j < len; j++) {
                cntArr[DNA.charAt(j) - 'A']++;
                cntArr[DNA.charAt(j - n) - 'A']--;
                add();
            }
            sb.append(map.values().stream().max(Comparator.comparingInt(o -> o)).get()).append('\n');
        }
        System.out.println(sb);
    }
}