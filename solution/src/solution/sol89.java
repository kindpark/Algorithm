package solution;
import java.util.*;
public class sol89 {
	public static void main(String[] args){
		int ans = 0;
		Scanner sc = new Scanner(System.in);
		StringBuilder s = new StringBuilder(sc.nextLine());
		StringBuilder t = new StringBuilder(sc.nextLine());
		
		while(s.length()< t.length()) {
			if(t.charAt(t.length() -1) == 'A') {
				t.delete(t.length()-1, t.length());
			}
			else if(t.charAt(t.length() -1) == 'B'){
				t.delete(t.length() -1, t.length());
				t.reverse();
			}
			
		}
		if(t.toString().equals(s.toString())) {
			ans = 1;

		}
		System.out.println(ans);
	}
}
