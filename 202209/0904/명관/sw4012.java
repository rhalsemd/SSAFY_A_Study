package 문제0904;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw4012 {
	static int [][] halfarr1;
	static boolean[] halfvisited1;
	static int [][] halfarr2;
	static boolean[] halfvisited2;
	static int h1count=0;
	static int h2count=0;
	static int halflen=0;
	static int sum=0;
	static int [][] food;
	static int sum1=0;
	static int sum2=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			food = new int[N][N];
			
			int [] arr=new int[N];
			boolean[] visited = new boolean[N]; //조합에 사용되는 변수들
			halflen = combinationcount(N,N/2);
			halfarr1=new int[halflen][N/2];
			halfarr2=new int[halflen][N/2];
			for(int i=0;i<N;i++) {
				arr[i]=i;
				String[] temp = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					food[i][j]= Integer.parseInt(temp[j]);
				}
			}
			combination(arr, visited, 0, N, N/2);
			for(int i=0;i<halflen;i++) {
				halfvisited1=new boolean[N/2];
				combinationfood(halfarr1[i],halfarr2[i], halfvisited1, 0, N/2, 2);
				if(i==0) {
					sum=Math.abs(sum1-sum2);
				}
				else if(sum>Math.abs(sum1-sum2)){
					sum=Math.abs(sum1-sum2);
				}
				sum1=0;
				sum2=0;
			}
			sb.append("#").append(t+1).append(" ").append(sum).append("\n");
			h1count=0;
			h2count=0;
		}
		bw.write(sb+"\n");
		bw.flush();
		bw.close();
    }

    //N개의 식재료를 N/2식재료 나뉘는 경우의 수
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    static void print(int[] arr, boolean[] visited, int n) {
        int acount=0;
        int bcount=0;
    	for (int i = 0; i < n; i++) {
            if (visited[i]) {
                halfarr1[h1count][acount++]=arr[i];
            }
            else {
                halfarr2[h2count][bcount++]=arr[i];
            }
        }
    	h1count++;
    	h2count++;
    }
    //반으로 나눈 조합들로 다시 조합을 짠다.
    static void combinationfood(int[] arr, int[] arr1, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            printfood(arr,arr1, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combinationfood(arr, arr1, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    static void printfood(int[] arr, int arr1[], boolean[] visited, int n) {	
    	int[] tmp1 = new int[2];
    	int[] tmp2 = new int[2];
    	int tmpcount=0;
    	for (int i = 0; i < n; i++) {
            if (visited[i]) {
            	tmp1[tmpcount]=arr[i];
            	tmp2[tmpcount]=arr1[i];
            	tmpcount++;
            }
        }
    	sum1 += food[tmp1[0]][tmp1[1]]+food[tmp1[1]][tmp1[0]];
    	sum2 += food[tmp2[0]][tmp2[1]]+food[tmp2[1]][tmp2[0]];
    }
    public static int combinationcount(int n, int r){

        if(n==r || r==0) return 1;
        return combinationcount(n-1, r-1) + combinationcount(n-1,r);

    }
}

