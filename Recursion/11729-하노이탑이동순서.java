import java.io.*;
import java.util.*;

public class Main {
    /*
    * 참고자료
    * https://shoark7.github.io/programming/algorithm/tower-of-hanoi
    * https://en.wikipedia.org/wiki/Tower_of_Hanoi
    * */

    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.print((int)Math.pow(2,n)-1);
        move(n,1,2,3);
        System.out.print(sb);
    }

    private static void move(int num, int start, int temp, int dest) {

        if(num == 1) {
            sb.append('\n').append(start).append(' ').append(dest);
            //System.out.printf("\n%d %d",start,dest);
            return;
        }

        move(num-1,start,dest,temp);
        sb.append('\n').append(start).append(' ').append(dest);
        //System.out.printf("\n%d %d",start,dest);
        move(num-1,temp,start,dest);
    }


}
