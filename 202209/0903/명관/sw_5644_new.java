package sovingclub.s0817;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos {
	int y, x;

	public Pos(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}

class Charge {
	int y, x, c, p;

	public Charge(int x, int y, int c, int p) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}

}

public class sw_5644_new {
	static int t;
	static int m, a;
	static ArrayList<Charge> arr;
	static int[] da;
	static int[] db;
	static int[] xpos = { 0, 0, 1, 0, -1 };
	static int[] ypos = { 0, -1, 0, 1, 0 };// 0상우하좌
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			arr = new ArrayList<>();
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			answer = 0;
			da = new int[m + 1];
			db = new int[m + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				da[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				db[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				arr.add(new Charge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Pos pa = new Pos(1, 1);
			Pos pb = new Pos(10, 10);
			int[] charge;
			for (int i = 0; i <= m; i++) {
				pa = new Pos(pa.y + ypos[da[i]], pa.x + xpos[da[i]]);
				pb = new Pos(pb.y + ypos[db[i]], pb.x + xpos[db[i]]);
				// 현재 위치에서 최대 충전량
				int max = 0;
				for (int j = 0; j < arr.size(); j++) {// i초에서 모든 충전기에서 충전가능성 본다
					for (int k = 0; k < arr.size(); k++) {
						int sum = 0;
						charge = new int[2];
						Charge temp = arr.get(j);
						Charge temp2 = arr.get(k);
						if (Math.abs(pa.x - temp.x) + Math.abs(pa.y - temp.y) <= temp.c) {
							charge[0] = temp.p;
						}
						if (Math.abs(pb.x - temp2.x) + Math.abs(pb.y - temp2.y) <= temp2.c) {
							charge[1] = temp2.p;
						}

						if (j != k) {
							sum = charge[0] + charge[1];
						} else {
							sum = Math.max(charge[0], charge[1]);
						}
						if (sum > max)
							max = sum;

					}
				}
				answer += max;
			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb + "\n");
		bw.flush();
		bw.close();
	}

}
