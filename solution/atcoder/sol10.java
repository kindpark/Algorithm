package atcoder;
import java.util.*;
public class sol10 {
	static long k;
	static int n,m;
	static int[]a;
	static int[][]s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        a=new int[m+1];
        s =new int[n+1][m+1];
        for(int i=1; i<=m; i++) {
        	a[i] =sc.nextInt(); 
        }
        sc.nextLine();
        int max=0;
        for(int i=1; i<=n; i++) {
        	String str = sc.nextLine();
        	s[i][0]+=i;
        	for(int j=1; j<=m; j++) {
        		if (str.charAt(j - 1) == 'o') {
        			s[i][j]=1;
        			s[i][0]+=a[j];
        		}
        	}
        	//System.out.println(i+" "+s[i][0]);
        	max=Math.max(max,s[i][0]);
        }
        for(int i=1; i<=n; i++) {
        	if(max>s[i][0]) {
        		System.out.println(returnAns(max-s[i][0],s[i]));
        	}else {
        		System.out.println(0);
        	}
        }
    }
    public static int returnAns(int diff, int[]p) {
    	List<Integer> get = new ArrayList<Integer>();
    	 for(int i=1; i<=m; i++) {
    		 if(p[i]==0) {
    			 get.add(a[i]);
    		 }
    	 }
    	 Collections.sort(get, Collections.reverseOrder());
    	 int returnNum=0;
    	 for (Integer value : get) {
    		 returnNum++;
             if(diff<value) {
               break;
             }else {
            	 diff-=value;
             }
         }
    	 return returnNum;
    }
}