import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        set.add(1);
        queue.add(1);
        int size, answer = 0;
        int depth = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                int num = queue.poll();
                if(num == N){
                    System.out.println(depth);
                    return ;
                }
                if(num * 3 <= N && !set.contains(num * 3)){
                    queue.add(num * 3);
                    set.add(num * 3);
                }
                if(num * 2 <= N && !set.contains(num * 2)){
                    queue.add(num * 2);
                    set.add(num * 2);
                }
                if(num + 1 <= N && !set.contains(num + 1)){
                    queue.add(num + 1);
                    set.add(num + 1);
                }
            }
            depth++;
        }
        System.out.println(answer);
        br.close();
    }
}