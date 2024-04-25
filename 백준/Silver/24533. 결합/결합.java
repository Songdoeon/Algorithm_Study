import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Ingredient{
    long a, b;

    public Ingredient(long a, long b) {
        this.a = a;
        this.b = b;
    }
    long sum(Ingredient ingredient){
        long energy = (this.a * ingredient.b) + (this.b * ingredient.a);
        this.a += ingredient.a;
        this.b += ingredient.b;

        return energy;
    }
}
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        long sum = 0;
        Ingredient ingredient = new Ingredient(n1, n2);
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            sum += ingredient.sum(new Ingredient(n1, n2));
        }
        System.out.println(sum);
    }

}