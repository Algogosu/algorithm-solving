// package boj15552;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// 파일 읽어오기
		// System.setIn(new FileInputStream("src/input.txt"));
        // [시간 초과]
        // 입력
		// Scanner scanner = new Scanner(System.in);
		// int T = scanner.nextInt();
        // for (int i = 0; i < T; i++) {
        //     int A = scanner.nextInt();
	    // 	int B = scanner.nextInt();
    	// 	// 출력
	    // 	System.out.println(A + B);
        // }
		// scanner.close();
        
        // [빠른 입출력] 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < T; i++) {
			String[] line = br.readLine().split(" ");
			int A = Integer.parseInt(line[0]);
			int B = Integer.parseInt(line[1]);
            // bw.write에 넣기 전에 문자열 형변환 해줘야 함
            // 개행문자(\n, 엔터)도 직접 넣어줘야 함
			bw.write(Integer.toString(A + B) + "\n");
		}
		br.close();
		
		bw.flush();
		bw.close();
	}

}
