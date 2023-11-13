package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol11 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= arr[i]; j++) {
				String p = String.valueOf(i +""+ j);
				int u = 0;
				//StringBuffer sb = new StringBuffer(p);
				for(int k = 0; k < p.length() -1; k++) {
					if(p.charAt(k) == p.charAt(k+1)) {
						u++;
					}
				}
				if(u == p.length() -1) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}
}
