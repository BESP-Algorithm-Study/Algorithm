import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();
		int cnt = 0;
		int [] cntStr1 = new int [26];
		int [] cntStr2 = new int [26];

		for(int i = 0; i<str1.length(); i++){
			cntStr1[str1.charAt(i) - 'a']++;
		}

		for(int i = 0; i<str2.length(); i++){
			cntStr2[str2.charAt(i) - 'a']++;
		}

		for(int i = 0; i<26; i++){
			cnt += Math.abs(cntStr1[i] - cntStr2[i]);
		}
		System.out.println(cnt);
	}
}
