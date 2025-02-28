import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int ans = 0;
    static int len;
    static int[] arr;
    static String s;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static void search(int depth, int idx){
        if(idx >= len) return ;
        char c = s.charAt(idx);
        if(c == '('){
            stack.push(2);
            search(depth+1, idx+1);
        }
        else if(c == '['){
            stack.push(3);
            search(depth+1, idx+1);
        }
        else if(c == ')'){
            if(stack.isEmpty() || stack.peek() != 2){
                ans = -1;
                return ;
            }
            else {
                if(arr[depth] == 0){
                    arr[depth - 1] += stack.pop();
                }
                else {
                    arr[depth - 1] += arr[depth] * stack.pop();
                    arr[depth] = 0;
                }
            }
            search(depth - 1, idx+1);
        }
        else{
            if(stack.isEmpty() || stack.peek() != 3){
                ans = -1;
                return ;
            }
            else {
                if(arr[depth] == 0) {
                    arr[depth - 1] += stack.pop();
                }
                else {
                    arr[depth - 1] += arr[depth] * stack.pop();
                    arr[depth] = 0;
                }
            }
            search(depth - 1, idx+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        len = s.length();
        arr = new int[16];
        search(0, 0);
        System.out.println(ans == -1 ? 0 : arr[0]);
    }
}
