package atcoder;
import java.util.*;
public class sol9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Player> p = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			p.add(new Player(0, i+1));
		}
		for(int i = 0; i < n; i++) {
			String a = sc.next();
			for(int j = 0; j < a.length(); j++) {
				if(a.charAt(j) == 'o') {
					p.get(i).score++;
				}
				else if(a.charAt(j) == 'x') {
					p.get(i).score--;
				}
			}
		}
		Collections.sort(p);
		for(int i = 0; i < n; i++) {
			System.out.print(p.get(i).number + " ");
		}
		
	}

}
class Player implements Comparable<Player>{
	int score;
	int number;
	Player(int score, int number){
		this.score = score;
		this.number = number;
	}
	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		return o.score - score;
	}
	public int getScore() {
		return score;
	}
}
