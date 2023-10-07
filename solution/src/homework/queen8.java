package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class queen8 {
	static int[] chess;
	static int n;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		chess = new int[n];
		travel(0);
		System.out.println(ans);
	}
	public static void travel(int move) {
		if (move == n) {
			ans++;
			return;
		}
		for (int i = 0; i < n; i++) {
			chess[move] = i;
			if (promising(move)) {
				travel(move + 1);
			}
		}
	}
	public static boolean promising(int column) {
		for (int i = 0; i < column; i++) {
			// 같은 행에 위치
			if (chess[column] == chess[i]) {
				return false;
			} 
			// 대각선에 놓여있는 경우. 
			else if (Math.abs(column - i) == 
					Math.abs(chess[column] - chess[i])) {
				return false;
			}
		}	
		return true;
	}
}
