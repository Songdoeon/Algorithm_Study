import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Info{
    int idx, cnt;

    public Info(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "Info{" +
                "char=" + (char)(idx +'a')  +
                ", cnt=" + cnt +
                '}';
    }
}
class Main {
    static int N, K;
    static boolean[] cnt = new boolean[26];
    static Map<String, Integer> map = new HashMap<>();
    static int[] idxs = new int[]{0,'n' - 'a','t' - 'a','i' - 'a','c' - 'a'};
    static int ans = 0;
    static void check(int depth, int len){
        if(len == K){
            int count = 0;
            for(String s : map.keySet()){
                int length = s.length();
                boolean find = true;
                for(int i = 0; i < length; i++){
                    if(!cnt[s.charAt(i) - 'a']) {
                        find = false;
                        break;
                    }
                }
                if(find)count += map.get(s);
            }
            ans = Math.max(ans, count);
            return ;
        }

        for(int i = depth; i < 26; i++){
            if(!cnt[i]){
                cnt[i] = true;
                check(i, len + 1);
                cnt[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            sb.setLength(0);
            int len = s.length() - 4;
            char[] chars = s.substring(4, len).toCharArray();
            len -= 4;
            for (int j = 0; j < len; j++) {
                if(j != 0 && chars[j] == chars[j-1]) continue;
                sb.append(chars[j]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        for (int i = 0; i < 5; i++) {
            cnt[idxs[i]] = true;
        }
        K -= 5;

        check(0, 0);

        System.out.println(ans);
    }
}