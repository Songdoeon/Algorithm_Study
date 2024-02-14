import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static long answer = 0;

    static int findFirstIndex(List<Integer> list,int target){
        int start = 0;
        int end = list.size();
        int mid;
        while(start < end){
            mid = (start + end) / 2;
            if(list.get(mid) < target){
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
    static int findLastIndex(List<Integer> list, int target){
        int start = 0;
        int end = list.size();
        int mid;
        while(start < end){
            mid = (start + end) / 2;
            if(list.get(mid) <= target){
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
    static void search2(int depth, int end,int sum, int check){
        if(depth == end) {

            list2.add(sum);
            return;
        }
        search2(depth + 1, end, sum + arr[depth], check + 1);
        search2(depth + 1, end, sum, check);
    }
    static void search(int depth, int end, int sum, int check){
        if(depth == end){
            list1.add(sum);
            return ;
        }

        search(depth + 1, end,sum + arr[depth],check + 1);
        search(depth + 1, end, sum,check);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int end = N / 2;
        search(0,end,0,0);

        search2(end, N,0,0);

        Collections.sort(list1);
        Collections.sort(list2);

        for (Integer integer : list1) {
            int target = S - integer;
            int upper = findLastIndex(list2, target);
            int lower = findFirstIndex(list2, target);
            answer += upper - lower;
        }

        System.out.println(S == 0 ? answer - 1 : answer);
    }
}
