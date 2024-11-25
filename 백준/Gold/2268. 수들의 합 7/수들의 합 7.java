import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

	static long tree[],arr[];
	public static long init(int start, int end, int node) {
		if(start == end) return tree[node] = arr[start];
		int mid = (start+end)/2;
		return tree[node] = init(start,mid,node*2) + init(mid+1,end,node*2+1);
	}
	public static long sum(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return 0;
		if(left <= start && end <= right) return tree[node];
		if(start == end) return tree[node];
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right) + sum(mid+1,end,node*2+1,left,right);
	}
	public static long modify(int start, int end, int node, int index, int val) {
		if(index < start || index > end) return tree[node];
		if(start == end) return tree[node] = val;
		int mid = (start+end)/2;
		return tree[node] = modify(start,mid,node*2,index,val) + modify(mid+1,end,node*2+1,index,val);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		tree = new long[4*N];
		arr = new long[N];
		init(0,N-1,1);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			if(a==0) {
				if(b<=c)
					bw.append(String.valueOf(sum(0,N-1,1,b,c))+"\n");
				else {
					bw.append(String.valueOf(sum(0,N-1,1,c,b))+"\n");
				}
			}
			else {
				modify(0,N-1,1,b,c+1);
				arr[b]=c+1;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}