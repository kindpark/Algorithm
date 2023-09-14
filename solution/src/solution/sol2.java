package solution;

import java.util.*;
import java.io.*;
public class sol2 {
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static boolean check[];
	static int n, m, v;
	static int matrix[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String[] arr = str.split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		v = Integer.parseInt(arr[2]);
		matrix = new int[n+1][n+1];
		check = new boolean[n+1];
		for(int i = 1; i <= m; i++) {
			str = br.readLine();
			arr = str.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			matrix[a][b] = matrix[b][a] = 1;
		}
		dfs(v);
		sb.append("\n");
		bfs(v);
		System.out.println(sb);
	}
	public static void bfs(int m) {
		check = new boolean[n+1];
		q.add(m);
		check[m] = true;
		while(!q.isEmpty()) {
			m = q.poll();
			sb.append(m + " ");
			for(int i = 1; i <=n; i++) {
				if(!check[i] && matrix[m][i] == 1) {
					q.add(i);
					check[i] = true; 
				}
			}
			m++;
		}
	}
	public static void dfs(int m) {
		check[m] = true;
		sb.append(m + " ");
		for(int i = 1; i <= n; i++) {
			if(!check[i] && matrix[m][i] == 1) {
				dfs(i);
			}
		}
	}
}
