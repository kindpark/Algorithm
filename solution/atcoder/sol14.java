package atcoder;

import java.util.*;
import java.io.*;
public class sol14{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
    	int cnt = 0;
    	int n = Integer.parseInt(br.readLine());
    	
    	String str = br.readLine();
    	/*
    	int[] s = new int[26];
    	int first = 0;
    	for(int j = 0; j < n; j++) {
        	if(str.charAt(first) != str.charAt(j)) {
        		if(s[str.charAt(j-1) - 97] < j-first) {
        			s[str.charAt(j-1) - 97] = j - first;
        		}
        		first = j;
        	}
    	}
    	for(int i = 0; i < 26; i++) {
        	cnt += s[i];
    	}
    	*/
    	str += 0;
    	String[] s = str.split("");
    	HashMap<String, Integer> hm = new HashMap<>();
    	String t = s[0];
    	int sum = 1;
    	for(int i = 1; i < s.length; i++) {
    		if(t.equals(s[i]))sum++;
    		else {
    			if(hm.get(t) == null) hm.putIfAbsent(t, sum);
    			else if(hm.get(t) < sum) hm.put(t, sum);
    			sum = 1;
    		}
    		t = s[i];
    			
    	}
    	for(int i : hm.values()) cnt += i;
    	System.out.println(cnt);
    }
}