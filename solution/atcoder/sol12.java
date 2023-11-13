package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuffer s = new StringBuffer(br.readLine());
		
		for(int i = 0; i < s.length() -2; i++) {
			if(s.charAt(i) == 'A' && s.charAt(i+1) == 'B' && s.charAt(i+2) == 'C') {
				s.delete(i, i+2);
				System.out.println(s.toString());
			}
		}
	}
}
