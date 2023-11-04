package atcoder;

import java.util.*;

public class sol3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String str = sc.next();
		String res ="No";
		for(int i = 0; i < a-1; i++) {
			if((str.charAt(i) == 'a' && str.charAt(i+1) == 'b') ||
					(str.charAt(i) == 'b' && str.charAt(i+1) == 'a')) {
				res = "Yes";
			}
		}
		System.out.println(res);
	}
}