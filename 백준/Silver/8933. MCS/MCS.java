import java.io.*;
import java.util.*;

class MCS{
    int A, G, T, C;

    public MCS(int a, int g, int t, int c) {
        A = a;
        G = g;
        T = t;
        C = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MCS mcs = (MCS) o;

        if (A != mcs.A) return false;
        if (G != mcs.G) return false;
        if (T != mcs.T) return false;
        return C == mcs.C;
    }

    @Override
    public int hashCode() {
        int result = A;
        result = 31 * result + G;
        result = 31 * result + T;
        result = 31 * result + C;
        return result;
    }
}
class Main{
    static int N;
    static int[] cntArr;
    static Map<MCS, Integer> map;
    static void add(){
        MCS mcs = new MCS(cntArr[0], cntArr[6], cntArr[19], cntArr[2]);
        map.put(mcs, map.getOrDefault(mcs, 0) + 1);
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