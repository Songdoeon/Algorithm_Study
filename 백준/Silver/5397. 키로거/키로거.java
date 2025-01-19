import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            int idx = 0;
            char[] arr = br.readLine().toCharArray();
//            StringBuilder tempStr = new StringBuilder();
            List<Character> list = new LinkedList<>();
            int len = arr.length;

            for (int j = 0; j < len; j++) {
                char exec = arr[j];
                if(exec == '<'){
                    if(idx > 0) idx--;
                }
                else if(exec == '>') {
                    if(idx != list.size()) idx++;
                }
                else if(exec == '-') {
                    if(idx != 0) {
                        list.remove(--idx);
                    }
                }
                else {
                    if(idx == list.size()) list.add(exec);
                    else list.add(idx, exec);
                    idx++;
                }
            }
            for(Character c : list){
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}