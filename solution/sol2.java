package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sol2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		double[] gift = new double[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			gift[i] = Double.parseDouble(st.nextToken());
			
		}
		//왜 이건가?
		int x = 0;
		int p = 0;
		Arrays.sort(gift);
		for(int j = 0; j < n; j++) {
			while(x < n && gift[x] < gift[j] + m) {
				p++;
				x++;
			}
			if(p - j> cnt) {
				cnt = p-j;
			}
		}
		System.out.println(cnt);
	}
 }
