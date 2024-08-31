import java.io.*;
import java.util.*;

class Mos{
    int start, end;

    public Mos(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Mos[] arr = new Mos[N];
        int[] starts = new int[N];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Mos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            starts[i] = arr[i].start;
            ends[i] = arr[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int idx = 0;
        
        int max = ends[N - 1];
        int ans = 0;
        int ret = 0;
        int s = 0;
        int e = 0;
        for (int i = 0; i < N; i++) {
            ret++;
            while (idx < max && starts[i] >= ends[idx]) {
                idx++;
                ret--;
            }
            if(ans == ret && starts[i] == e){
                e = ends[idx];
            }
            else if (ans < ret){
                e = ends[idx];
                s = starts[i];
                ans = ret;
            }
        }
        System.out.println(ans + " \n" + s + " " + e);
    }
}