import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		int[] result = new int[t];

		for(int i=0;i<t;i++) {

			Integer[] arr = new Integer[10];

			String[] str = br.readLine().split(" ");

			for(int j=0;j<10;j++) {
				arr[j] = Integer.parseInt(str[j]);
			}

			Arrays.sort(arr, Collections.reverseOrder());

			result[i] = arr[2];
		}

		for(int i=0;i<t;i++) {
			System.out.println(result[i]);
		}

	}

}