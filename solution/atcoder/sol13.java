package atcoder;

import java.io.*;
import java.util.*;

public class sol13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		//StringBuffer s = new StringBuffer(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int[] vt = new int[n+1];
		int vote = 0;
		int winner = 1;
		for(int i = 0; i < m; i++) {
			int player = a[i];
			vt[player] ++;
			if(vote == vt[player] && winner > player) {
				winner = player;
			}
			else if(vote < vt[player]) {
				winner = player;
				vote = vt[player];
			}
			System.out.println(winner);
		}
	}
}
