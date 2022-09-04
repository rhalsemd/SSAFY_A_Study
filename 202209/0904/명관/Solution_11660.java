package 문제0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_11660 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] NM = bf.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[][] arr = new int[N][N];
		int[][] sumarr = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			String[] ntmp = bf.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i - 1][j] = Integer.parseInt(ntmp[j]);
				sumarr[i][j + 1] = arr[i - 1][j] + sumarr[i][j];
			}
			if (i < N) {
				sumarr[i + 1][0] = sumarr[i][N];
			}
		}
		/*
		 * for(int i=1;i<N+1;i++) { sumarr[i][0]=sumarr[i-1][N]; }
		 */
		for (int i = 0; i < M; i++) {
			String[] ntmp = bf.readLine().split(" ");
			int jstart = Integer.parseInt(ntmp[0]);
			int jend = Integer.parseInt(ntmp[1]);
			int kstart = Integer.parseInt(ntmp[2]);
			int kend = Integer.parseInt(ntmp[3]);
			int result = 0;
			if (jstart == kstart && jend == kend) {
				result=arr[jstart - 1][jend - 1];
				sb.append(result).append('\n');
			} 
			else {
				for (int j = jstart; j <= kstart; j++) {
					//System.out.println(j+" "+kend+" "+jend);
					result += (sumarr[j][kend] - sumarr[j][jend - 1]);
					System.out.println(result);
				}
				sb.append(result).append('\n');
			}
		}
		for(int[] a : sumarr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(sb);
		

	}

}
