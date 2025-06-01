import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 전체 학생 수
		int K = Integer.parseInt(st.nextToken()); // 방 최대 인원

		int [][] arr = new int [2][7];
		int rooms = 0;

		for(int i = 0; i < N; i++){ // i = 1부터가 아니라 0부터 N-1까지
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			arr[S][Y]++;
		}

		for(int i = 0; i < 2; i++){
			for(int j = 1; j < 7; j++){
				if(arr[i][j] > 0) {
					if(arr[i][j] % K == 0){
						rooms += arr[i][j] / K;
					} else {
						rooms += (arr[i][j] / K) + 1;
					}
				}
			}
		}
		System.out.println(rooms);
	}
}
