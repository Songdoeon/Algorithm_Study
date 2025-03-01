import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Clazz{
    int s, e;

    public Clazz(int s, int e) {
        this.s = s;
        this.e = e;
    }
}
public class Main {
    static int N, M;
    static Clazz[] arr, rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Clazz[N];
        rooms = new Clazz[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Clazz(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, (o1, o2) -> o1.e == o2.e ? o2.s - o1.s : o1.e - o2.e);
        Arrays.fill(rooms, new Clazz(0, 0));
        int ans = 0;
        for(int i = 0; i < N; i++){
            Clazz c = arr[i];
            int idx = -1;
            int endTime = -1;
            for(int j = 0; j < M; j++){
                Clazz room = rooms[j];
                if(endTime < room.e && room.e < c.s){
                    idx = j;
                    endTime = room.e;
                }
            }
            if(idx != -1){
                rooms[idx] = c;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
