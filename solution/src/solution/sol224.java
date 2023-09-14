package solution;
import java.util.*;
import java.io.*;
public class sol224 {
	static int n, delete, ans;
	static boolean[] check;
	static int[][] tree;
	public static void deleteNode(int d) {
		for(int i = 0; i < n; i++) {
			if(tree[d] == tree[i]) {
				for(int j = 0; j < n; j++) {
					tree[d][j] = -2;
					tree[j][d] = -2;
				}
			}
		}
	}
	public static void dfs(int start) {
		check[start] = true;
		int pt = 0;
		for(int i = 0; i < n; i++) {
			
			if(!check[i] && (tree[start][i] != -2 && tree[start][i] != 0)) {
				System.out.println(start + " " + i + "실행");
				check[i] = true;
				for(int j = 0; j < n; j++) {
					if(tree[start][j] != 0 && tree[start][j] != -2) {
						pt++;
						System.out.println(j + "가 더해짐");
						System.out.println(tree[start][j] + " " + pt);		
					}
				}
				if(pt == 3) {
					ans++;
				}
				pt = 0;
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		tree = new int[n][n];
		check = new boolean[n];
		for(int i = 0; i < n; i++) {
			int s = Integer.parseInt(st.nextToken());
			if(s >= 0) {
				tree[i][s] = tree[s][i] = i;
			}
		}
		delete = Integer.parseInt(br.readLine());
		deleteNode(delete);
		dfs(0);
		System.out.println(ans);
	}
}
