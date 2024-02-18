import java.io.*;
import java.util.*;
public class Main {

    static List<Integer> list = new ArrayList<>();
    static List<Integer> idxList = new ArrayList<>();

    static int search(int target) {
        int start = 0; // false
        int end = list.size(); // true
        int mid;
        if (list.get(end - 1) < target) {
            return -2;
        }
        while (start < end) {
            mid = (start + end) / 2;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(arr[0]);
        idxList.add(0);
        for (int i = 1; i < n; i++) {
            int index = search(arr[i]);

            if (index == -2) {
                idxList.add(list.size());
                list.add(arr[i]);
            }
            else{
                idxList.add(index);
                list.set(index, arr[i]);
            }

        }

        System.out.println(list.size());
    }
}