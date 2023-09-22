package solution;
import java.util.*;
import java.io.*;
public class sol227 {
	static int n;
	static int a =1;
	static int ans = -1;
	static int[] arr;
	static String[] nm;
	static StringBuilder sb, q;
	
	static Stack<Integer> st;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		arr = new int[n+1];
		q = new StringBuilder();
		int factorial = 1;
 		for(int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(s[i-1]);
			q.append(arr[i] + " ");
			factorial *= i;
		}
 		System.out.println(factorial);
 		Arrays.sort(arr);
 		nm = new String[210000000];
 		st = new Stack<>();
 		check = new boolean[n+1];
 		sb = new StringBuilder();
 		bt(n, n);
 		for(int i = 1; i <= nm.length; i++) {
 			if(q.toString().equals(nm[i])) {
 				if(nm[i+1] == null) {
 					System.out.println(-1);
 					break;
 				}
 				System.out.println(nm[i+1]);
 				break;
 			}
 		}
	}
	
	public static void bt(int n, int r) {
		if(st.size() == r) {
			for(int i : st) {
				sb.append(i + " ");
				
			}
			nm[a] = sb.toString();
			a++;	
			sb = new StringBuilder();
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(!check[i]) {
				check[i] = true;
				st.push(arr[i]);
				bt(n, r);
				st.pop();
				check[i] = false;
			}
		}
	}

}
