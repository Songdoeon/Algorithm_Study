import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

// 27172 21:00 시작
class Pos{
    int key, value;

    public Pos(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return key == pos.key;
    }

    public int hashCode(){
        return Objects.hash(key);
    }
}
class Main{
    static int N;
    static int[] arr, point;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        point = new int[N];
        int max = 0;
        arr = new int[1_000_001];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            max = Math.max(max, n);
            arr[n] = i + 1;
            set.add(n);
        }
        for(int num : set){
            for(int i = num * 2; i <= max; i += num){
//                System.out.println(num + " : " + i);
                if(arr[i] != 0){
                    point[arr[num] - 1]++;
                    point[arr[i] - 1]--;
                }
            }
        }
        for(int p : point){
            sb.append(p).append(' ');
        }
        System.out.println(sb);
    }
}