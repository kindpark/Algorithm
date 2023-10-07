package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class queen8 {
	static int[] arr;
	static int n;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		nQueen(0);
		System.out.println(count);
	}
	public static void nQueen(int depth) {
		if (depth == n) {
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			if (Possibility(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	public static boolean Possibility(int col) {
		for (int i = 0; i < col; i++) {
			// 같은 행에 위치
			if (arr[col] == arr[i]) {
				return false;
			} 
			// 대각선에 놓여있는 경우. 
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}	
		return true;
	}
}
