import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static Set<Integer> set = new HashSet<>();

    static void all(){
        set.clear();
        for(int i = 1; i <= 20; i++){
            set.add(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        String exec;
        int num = 0;
        for(int i = 0; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            exec = st.nextToken();
            if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());
            switch (exec){
                case "add" : set.add(num);break;
                case "remove" : set.remove(num);break;
                case "check" : if(set.contains(num)) sb.append('1').append('\n'); else sb.append('0').append('\n');break;
                case "toggle" : if(set.contains(num)) set.remove(num); else set.add(num); break;
                case "all" : all();break;
                case "empty" : set.clear();
            }
        }
        System.out.println(sb);
    }
}
