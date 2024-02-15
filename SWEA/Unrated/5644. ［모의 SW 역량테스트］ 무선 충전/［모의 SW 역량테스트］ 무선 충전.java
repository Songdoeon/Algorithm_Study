import java.util.*;
import java.io.*;

class BC{
    int num;
    int power;

    public BC(int num, int power) {
        this.num = num;
        this.power = power;
    }
}
class Solution {
    static int N, M;
    static int[][] userA, userB;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    static int distance(int[] point, int x, int y){
        return Math.abs(point[0] - x) + Math.abs(point[1] - y);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            List<List<BC>> listA = new ArrayList<>();
            List<List<BC>> listB = new ArrayList<>();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int mov;
            userA = new int[N + 1][2];
            userB = new int[N + 1][2];
            userA[0] = new int[] {1, 1};
            userB[0] = new int[] {10, 10};

            st = new StringTokenizer(br.readLine());
            listA.add(new ArrayList<>());
            listB.add(new ArrayList<>());
            for(int i = 1; i <= N; i++){
                mov = Integer.parseInt(st.nextToken());
                listA.add(new ArrayList<>());
                switch (mov){
                    case 0 : userA[i][0] = userA[i - 1][0] + dx[0];userA[i][1] = userA[i - 1][1] + dy[0];break;
                    case 1 : userA[i][0] = userA[i - 1][0] + dx[1];userA[i][1] = userA[i - 1][1] + dy[1];break;
                    case 2 : userA[i][0] = userA[i - 1][0] + dx[2];userA[i][1] = userA[i - 1][1] + dy[2];break;
                    case 3 : userA[i][0] = userA[i - 1][0] + dx[3];userA[i][1] = userA[i - 1][1] + dy[3];break;
                    case 4 : userA[i][0] = userA[i - 1][0] + dx[4];userA[i][1] = userA[i - 1][1] + dy[4];break;
                }
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                mov = Integer.parseInt(st.nextToken());
                listB.add(new ArrayList<>());
                switch (mov){
                    case 0 : userB[i][0] = userB[i - 1][0] + dx[0];userB[i][1] = userB[i - 1][1] + dy[0];break;
                    case 1 : userB[i][0] = userB[i - 1][0] + dx[1];userB[i][1] = userB[i - 1][1] + dy[1];break;
                    case 2 : userB[i][0] = userB[i - 1][0] + dx[2];userB[i][1] = userB[i - 1][1] + dy[2];break;
                    case 3 : userB[i][0] = userB[i - 1][0] + dx[3];userB[i][1] = userB[i - 1][1] + dy[3];break;
                    case 4 : userB[i][0] = userB[i - 1][0] + dx[4];userB[i][1] = userB[i - 1][1] + dy[4];break;
                }
            }
            for(int ap = 0; ap < M; ap++){
                st = new StringTokenizer(br.readLine());

                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int coverage = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                BC bc = new BC(ap, p);
                for(int j = 0; j <= N; j++){
                    if(distance(userA[j], x, y) <= coverage) {
                        listA.get(j).add(bc);
                    }
                    if(distance(userB[j], x, y) <= coverage) {
                        listB.get(j).add(bc);
                    }
                }
            }
            for(int i = 0; i <= N; i++){
                listA.get(i).sort((o1, o2) -> o2.power - o1.power);
                listB.get(i).sort((o1, o2) -> o2.power - o1.power);
            }
            for(int i = 0; i <= N; i++){
                BC removeBC = new BC(0, 0);
                boolean check = false;

                if(listA.get(i).isEmpty() || listB.get(i).isEmpty()) continue;
                if(listA.get(i).get(0).num == listB.get(i).get(0).num) {
                    check = true;
                    removeBC = listA.get(i).get(0);
                }

                if(check){
                    if(listB.get(i).size() > 1 && listA.get(i).size() > 1){
                        int pB = listB.get(i).get(1).power;
                        int pA = listA.get(i).get(1).power;
                        if(pB > pA) listB.get(i).remove(removeBC);
                        else listA.get(i).remove(removeBC);
                    }
                    else if(listA.get(i).size() == 1)listB.get(i).remove(removeBC);
                    else if(listB.get(i).size() == 1)listA.get(i).remove(removeBC);
                    else if(!listB.get(i).isEmpty())listB.get(i).remove(removeBC);
                    else if(!listA.get(i).isEmpty())listA.get(i).remove(removeBC);
                }
            }
            for(int i = 0; i <= N; i++){
                int s = sum;
                if(!listA.get(i).isEmpty()){
                    sum += listA.get(i).get(0).power;
                }
                if(!listB.get(i).isEmpty()){
                    sum += listB.get(i).get(0).power;
                }
            }
            sb.append("#").append(t).append(" ").append(sum).append('\n');
        }

        System.out.println(sb);
    }

}