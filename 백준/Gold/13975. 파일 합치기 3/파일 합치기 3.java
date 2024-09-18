import java.io.*;
import java.util.*;

class Main {
    static int t, N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        Queue<Long> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        int[] arr;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            Queue<Long> sumQue = new ArrayDeque<>();
            int index = 0;
            long totalCost = 0;
            for (int i = 0; i < n;) {
                long currentSum = 0;
                for (int j = 0; j < 2; j++) {
                    if (i < n && (sumQue.isEmpty() || arr[i] < sumQue.peek())) {
                        currentSum += arr[i++];
                    } else {
                        currentSum += sumQue.poll();
                    }
                }

                totalCost += currentSum;
                sumQue.add(currentSum);
            }
            while (sumQue.size() >= 2) {
                Long currentSum = sumQue.poll();
                currentSum += sumQue.poll();
                totalCost += currentSum;
                sumQue.add(currentSum);
            }

            sb.append(totalCost).append('\n');

        }
        System.out.println(sb);
    }
}