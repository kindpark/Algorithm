package codeforces;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
 
public class B_div2_0620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> palindromeSet = new HashMap<>();
        LinkedList<String> nonPairs = new LinkedList<>();
        LinkedList<String> palindromeItself = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(palindromeSet.isEmpty() && nonPairs.isEmpty()){
                if(isParlindromeItself(str)){
                    palindromeItself.add(str);
                }else{
                    nonPairs.add(str);
                }
            }else{
                if(isParlindromeItself(str)){
                    palindromeItself.add(str);
                }else{
                    boolean doesPairExist = false;
                    for (int j = 0; j < nonPairs.size(); j++) {
                        if(isPalindromePair(str, nonPairs.get(j))){
                            palindromeSet.put(str, nonPairs.get(j));
                            nonPairs.remove(j);
                            doesPairExist = true;
                            break;
                        }
                    }
                    if(!doesPairExist){
                        nonPairs.add(str);
                    }
                }
            }
        }
        Iterator<String> keyIter = palindromeSet.keySet().iterator();
        String[] pairs = new String[palindromeSet.size()];
        int tmpIndex = 0;
        while(keyIter.hasNext()){
            pairs[tmpIndex++] = keyIter.next();
        }
        if(tmpIndex == 0){
            if(!palindromeItself.isEmpty()){
                sb.append(m).append("\n").append(palindromeItself.get(0));
            }else{
                sb.append(0).append("\n").append("");
            }
        }else{
            if(!palindromeItself.isEmpty()){
                sb.append(tmpIndex * 2 * m + m).append("\n");
            }else{
                sb.append(tmpIndex * 2 * m).append("\n");
            }
            for (int i = 0; i < tmpIndex; i++) {
                sb.append(pairs[i]);
            }
            if(!palindromeItself.isEmpty()){
                sb.append(palindromeItself.get(0));
            }
            for (int i = 0; i < tmpIndex; i++) {
                sb.append(palindromeSet.get(pairs[tmpIndex - 1 - i]));
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static boolean isPalindromePair(String str1, String str2){
        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();
        boolean isPair = true;
        for (int i = 0; i < str1.length(); i++) {
            if(chArr1[i] != chArr2[str1.length() - 1 - i]){
                isPair = false;
                break;
            }
        }
        return isPair;
    }
 
    private static boolean isParlindromeItself(String str){
        boolean isPair = true;
        char[] chArr = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            if(chArr[i] != chArr[str.length() - 1 - i]){
                isPair = false;
                break;
            }
        }
        return isPair;
    }
}
