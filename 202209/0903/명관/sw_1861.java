package sovingclub.s0809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_1861 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,1,-1};
		
		int T=Integer.parseInt(st.nextToken());
		for (int i=1;i<T+1;i++) {
			int r_count=1;
			int num=0;
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st2.nextToken());
			
			int [][] arr = new int[N][N];
			for(int j=0;j<N;j++) {
				StringTokenizer tokenizer1 = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < N; j2++) {
					arr[j][j2]=Integer.parseInt(tokenizer1.nextToken());
				}
			}
			for(int j=0;j<N;j++) {
				for (int j2 = 0; j2 < N; j2++) {
					int count = 1;
					int tmpj2=j2;
					int tmpj=j;
					int isVisit[][] = new int[N][N];
					for(int j3 =0;j3<4;j3++) {
						int sx=dx[j3]+tmpj;
						int sy=dy[j3]+tmpj2;
						if(sx>=0&&sx<N&&sy>=0&&sy<N&&arr[sx][sy]==arr[tmpj][tmpj2]+1&&isVisit[sx][sy] == 0) {
							isVisit[sx][sy]=1;
							count++;
							j3=0;
							tmpj=sx;
							tmpj2=sy;
						}
						
					}
					//System.out.println(count);
					if(r_count<count) {
						num=arr[j][j2];
						r_count=count;
					}
					else if(r_count==count&&num>arr[j][j2]) {
						num=arr[j][j2];
					}
				}
			}
			
			
			sb.append("#").append(i).append(" ").append(num).append(" ").append(r_count).append("\n");
		}
		bw.write(sb+"\n");
		bw.flush();
		bw.close();
	}

}
