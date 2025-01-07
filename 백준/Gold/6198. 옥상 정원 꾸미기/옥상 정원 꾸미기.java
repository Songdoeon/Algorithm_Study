import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Building{
    int high, cnt;

    public Building(int high, int cnt) {
        this.high = high;
        this.cnt = cnt;
    }
}
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Stack<Building> stack = new Stack<>();

        long ans = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            Building b = new Building(n, 0);
//            System.out.println(n + " 시작");
            while(!stack.isEmpty()){
                Building prev = stack.peek();
//                System.out.println("prev : " + prev.high + " cnt : " + prev.cnt);
                if(prev.high < n) {
                    int h = stack.pop().cnt;
                    ans += h;
                    if(!stack.isEmpty()) stack.peek().cnt += h;
//                    stack.push(b);
                }
                else if(prev.high > n){
                    prev.cnt++;
//                    stack.push(b);
                    break;
                }
                else{
//                    System.out.println("여긴 오지마라");
                    if(stack.size() > 1) stack.get(stack.size() - 2).cnt++;
                    break;
                }
            }
            if(stack.isEmpty() || stack.peek().high != n) stack.push(b);
        }
//        System.out.println("size : " + stack.size());
        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop().cnt;
            ans += ret;
//            System.out.println(stack.size() + " : " + ans);
        }
        System.out.println(ans);
    }
}