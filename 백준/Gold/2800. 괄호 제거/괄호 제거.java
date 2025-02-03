import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Pair{
    int s, e;
    public Pair(int s, int e){
        this.s = s;
        this.e = e;
    }
}
public class Main {
    static String line;
    static int len;
    static int size;
    static Set<String> set = new TreeSet<>();
    static boolean[] visited;
    static boolean[] word;
    static List<Pair> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean flag = false;
    static void check(int depth){
        if(depth == -1) {
            Arrays.fill(word, true);
            for (int i = 0; i < size; i++) {
                if(!visited[i]){
                    Pair p = list.get(i);
                    word[p.s] = false;
                    word[p.e] = false;
                }
            }
            StringBuilder tempSb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if(!word[i]) continue;
                tempSb.append(line.charAt(i));
            }
            if(set.contains(tempSb.toString())) {
                return ;
            }
            set.add(tempSb.toString());
//            tempSb.append('\n');
//            sb.insert(0, tempSb);
            return ;
        }

            visited[depth] = false;
            check(depth - 1);
            visited[depth] = true;
            check(depth - 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();

        line = br.readLine();
        len = line.length();
        word = new boolean[len];
        for (int i = 0; i < len; i++) {
            char c = line.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else if(c == ')'){
                list.add(new Pair(stack.pop(), i));
            }
        }
        size = list.size();
        visited = new boolean[size];

        check(size - 1);

        for (String s : set) {
            sb.append(s).append('\n');
        }
        System.out.println(sb.delete(0, len + 1));
    }
}
