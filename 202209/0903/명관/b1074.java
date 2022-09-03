package backjoon_assignment.b0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1074 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r= Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		int pow_n = (int)Math.pow(2, N);
		int count = 0;
		int a = 0;
		int b = 0;
		
		while (pow_n > 0) {
			pow_n /= 2;

            // 왼쪽 위
            if (r < a+pow_n && c < b+pow_n) {
                count += pow_n * pow_n * 0;
            }
            // 오른쪽 위
            else if (r < a+pow_n) {
                count += pow_n * pow_n * 1;
                b += pow_n;
            }
            // 왼쪽 아래
            else if (c < b+pow_n) {
                count += pow_n * pow_n * 2;
                a += pow_n;
            }
            // 오른쪽 아래
            else {
                count += pow_n * pow_n * 3;
                a += pow_n;
                b += pow_n;
            }
            //System.out.println(n+" "+count);
            if(pow_n == 1) {
                System.out.println(count);
                break;
            }
        }
		
		
	}

}
