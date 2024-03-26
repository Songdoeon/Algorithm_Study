import java.util.*;
import java.io.*;

class Employee{
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
class Main{
    static int N, M, K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Employee> queue = new PriorityQueue<>((o1, o2) -> o2.salary - o1.salary);

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            queue.offer(new Employee(st.nextToken(), Integer.parseInt(st.nextToken())));
        }


        long sum = 0;
        int idx = 0;
        while (idx <= K && idx++ < N){
            Employee e = queue.poll();
            sum += e.salary;
            sb.append(e.name).append(',').append(" YOU ARE FIRED!").append('\n');
            if(sum >= M) break;
        }
        System.out.println(sum >= M && idx <= K ? idx + "\n" + sb : "impossible");
    }
}
