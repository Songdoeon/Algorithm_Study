import java.time.*;
import java.util.*;
import java.io.*;

class Streak{
    String name;
    int len, freeze, start, fail;

    public Streak(String name, int len, int freeze, int start, int fail) {
        this.name = name;
        this.len = len;
        this.freeze = freeze;
        this.start = start;
        this.fail = fail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Streak strict = (Streak) o;

        if (len != strict.len) return false;
        if (freeze != strict.freeze) return false;
        if (start != strict.start) return false;
        return (fail == strict.fail);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + len;
        result = 31 * result + freeze;
        result = 31 * result + start;
        result = 31 * result + fail;
        return result;
    }

    @Override
    public String toString() {
        return "Streak{" +
                "name='" + name + '\'' +
                ", len=" + len +
                ", freeze=" + freeze +
                ", start=" + start +
                ", fail=" + fail +
                '}';
    }
}
class Main {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Streak> queue = new PriorityQueue<>((o1, o2) -> o1.len != o2.len ? o2.len - o1.len :
                o1.freeze != o2.freeze ? o1.freeze - o2.freeze :
                        o1.start != o2.start ? o1.start - o2.start :
                                o1.fail != o2.fail ? o1.fail - o2.fail :
                                        o1.name.compareTo(o2.name)
        );
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            String streak = "";
            for (int j = 0; j < 7; j++) {
                streak += br.readLine();
            }
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < K; j++) {
                int idx = j;
                for (int k = 0; k < 7; k++) {
                    temp.append(streak.charAt(idx));
                    idx += K;
                }
            }
            String[] arg = temp.toString().split("X");
//            for (String s : arg) {
//                System.out.println("s = " + s);
//            }
//            System.out.println("---");
            int size = arg.length;
            int idx = 0;
            int start = 0;
            int freeze = Integer.MAX_VALUE;
            int len = 0;
            for (int j = 0; j < size; j++) {

                String s = arg[j].replaceAll("[^O]","");
                int tempLen = s.length();
                int startF = 0;
                if(tempLen >= len){
                    String tempS = arg[j];
                    while (tempS.startsWith("F")){
                        startF++;
//                        System.out.println("startF = " + startF);
                        tempS = tempS.substring(1);
                    }
                    while (tempS.endsWith("F")){
                        tempS = tempS.substring(0, tempS.length() - 1);
                    }
                    int tempFreeze = tempS.replaceAll("[^F]","").length();
                    if(tempLen > len){
                        start = idx + startF;
                        freeze = tempFreeze;
                        len = tempLen;
                    }
                    else if(tempFreeze < freeze){
                        freeze = tempFreeze;
                        start = idx + startF;
                    }
                }
                idx += arg[j].length() + 1;
            }
            int fail = streak.replaceAll("[^X]","").length();
            queue.add(new Streak(name, len, freeze, start, fail));
        }
        int idx = 1;
        while (!queue.isEmpty()){
            Streak s = queue.poll();
            sb.append(idx).append('.').append(' ').append(s.name).append('\n');
            while (!queue.isEmpty() && s.equals(queue.peek())){
                Streak s2 = queue.poll();
                sb.append(idx).append('.').append(' ').append(s2.name).append('\n');
            }
            idx++;
        }
        System.out.println(sb);
    }
}