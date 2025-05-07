import java.util.*;
import java.io.*;
 
public class Main {
    static int N, K;
    static ArrayList<Node> list = new ArrayList<>();
    static int endPoint = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());   // 국가 수
        K = Integer.parseInt(st.nextToken());   // 등수 알고 싶은 국가
 
        // 입력 받기
        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            
            list.add(new Node(num, gold, silver, bronze, 0));
        }
        
        Collections.sort(list);
        list.get(0).rank = 1;    // 🔔 정렬 후, 리스트의 첫 번째 국가는 1등
        
        // 🔔 등수 매겨주기 (리스트의 이전 원소와 비교) 🔔
        for(int i = 1 ; i < list.size() ; i++) {
            Node now = list.get(i);
            
            int prevG = list.get(i - 1).g;
            int prevS = list.get(i - 1).s;
            int prevB = list.get(i - 1).b;
            
            // 국가 번호가 K면, 그것이 바로 endPoint (마지막 정답 출력 시 사용)
            if(list.get(i).num == K) {
                endPoint = i;
            }
            
            if(now.g == prevG && now.s == prevS && now.b == prevB) {
                list.get(i).rank = list.get(i - 1).rank;
            }
            else {
                list.get(i).rank = i + 1; // 🔔
            }
        }
        
        
        // 찾는 등수 원소 구하기
        System.out.println(list.get(endPoint).rank);
    }
}
 
class Node implements Comparable<Node>{
    int num, g, s, b, rank;
    
    Node(int num, int g, int s, int b, int rank) {
        this.num = num;
        this.g = g;
        this.s = s;
        this.b = b;
        this.rank = rank;
    }
    
    // 메달, 내림차순 정렬
    @Override
    public int compareTo(Node n) {
        if(this.g == n.g) {
            if(this.s == n.s) {
                return n.b - this.b;
            }
            else {
                return n.s - this.s;
            }
        }
        else {
            return n.g - this.g;
        }
    }
}