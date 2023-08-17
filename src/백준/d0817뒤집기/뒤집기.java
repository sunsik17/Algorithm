package 백준.d0817뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기 {

	static boolean zeroPass;
	static boolean onePass;
	static int oneCnt;
	static int zeroCnt;
	static String S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '0' && !zeroPass) {
				zeroPass = true;
				zeroCnt++;
				onePass = false;
			} else if (S.charAt(i) == '1' && !onePass){
				onePass = true;
				oneCnt++;
				zeroPass = false;
			}
		}

		System.out.println(Math.min(oneCnt, zeroCnt));
	}

}
