import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 16439

public class Main {
    static String str;
    static String PPAP = "PPAP";
    static Stack<Character> stack = new Stack<>();
    static boolean check(){
        int size = stack.size();
        if(size <= 3) return false;
        if(stack.get(size - 1) == 'P' && stack.get(size - 2) == 'A' &&
        stack.get(size - 3) == 'P' && stack.get(size - 4) == 'P') return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int len = str.length();

        for (int i = 0; i < len; i++) {
            stack.push(str.charAt(i));
            while(check()){
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }
        if(stack.size() == 1 && stack.peek()=='P') System.out.println(PPAP);
        else System.out.println("NP");
    }
}
