import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			char [] input = st.nextToken().toCharArray();
			char [] input2 = st.nextToken().toCharArray();

			int [] arr = new int [26];

			for (int j = 0; j < input.length; j++) {
				arr[input[j] - 'a']++;
			}
			for (int j = 0; j < input2.length; j++) {
				arr[input2[j] - 'a']--;
			}
			boolean flag = true;
			for (int cnt : arr){
				if(cnt !=0){
					flage =false;
					break;
				}
			}
			System.out.println(flag ? "Possible" : "Impossible");
		}
	}
}
