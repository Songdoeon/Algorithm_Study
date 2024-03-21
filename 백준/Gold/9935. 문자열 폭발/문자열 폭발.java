import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        String word = br.readLine();
        int wordLen = word.length();
        Stack<Character> stack = new Stack<>();
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stack.push(arr[i]);
            if(stack.size() >= wordLen && stack.peek() == word.charAt(wordLen - 1)){
                int idx = 1;
                for (int j = wordLen - 2; j >= 0; j--) {
                    if(stack.get(stack.size() - idx - 1) != word.charAt(j)) break;
                    idx++;
                }
                if(idx == wordLen){
                    for (int j = 0; j < wordLen; j++) {
                        stack.pop();
                    }
                }
            }
        }
        for (Character c : stack) {
            sb.append(c);
        }
        if(stack.isEmpty()) System.out.println("FRULA");
        else System.out.println(sb);
    }
}
