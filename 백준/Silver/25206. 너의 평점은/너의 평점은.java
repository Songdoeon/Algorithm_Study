import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double total = 0;
        double sum = 0;
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
            String name = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String alpha = st.nextToken();
            switch (alpha) {
                case "A+": total += score; sum += 4.5 * score; break;
                case "A0": total += score; sum += 4.0 * score; break;
                case "B+": total += score; sum += 3.5 * score; break;
                case "B0": total += score; sum += 3.0 * score; break;
                case "C+": total += score; sum += 2.5 * score; break;
                case "C0": total += score; sum += 2.0 * score; break;
                case "D+": total += score; sum += 1.5 * score; break;
                case "D0": total += score; sum += score; break;
                case "F" : total += score; break;
                case "P" : break;
            }
        }
        System.out.printf("%f",sum / total);
    }
}
