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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String word = br.readLine();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if(str.contains(word)){
                System.out.println("yes");
                return ;
            }
            word = word.substring(1) + word.charAt(0);
        }
        System.out.println("no");
    }
}