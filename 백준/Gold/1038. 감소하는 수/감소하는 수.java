import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 1038 11:10 시작!

class Main{
    static int N;
    static List<Long> list = new ArrayList<>();
    static void search(long num, int len){
        if(len > 10) return ;
        list.add(num);
        long end = num % 10;
        for (long i = 0; i < end; i++) {
            search(num * 10 + i, len + 1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 10; i++) {
            search(i, 0);
        }
        if(N >= list.size()){
            System.out.println(-1);
            return ;
        }
        Collections.sort(list);
        System.out.println(list.get(N));
    }
}