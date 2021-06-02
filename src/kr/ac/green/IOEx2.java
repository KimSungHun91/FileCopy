package kr.ac.green;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Input, 읽기
public class IOEx2 {
	public static void main(String[] args) {
		// finally 블록에서 쓸려고 null 초기화, 안하면 널포인트 뜸
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("test.txt");
			// 읽어올 데이터를 담을 변수, -1이 끝
			int data = -1; 
			
			// 1. 아래 코드와 같음, 줄인 것
			while ((data = fis.read()) != -1) {
				System.out.println((char)data);
			}
			
//			// 2. 풀어쓴것
//			boolean flag = true;
//			while (flag) {
//				// read()로 순차적으로 char값을 리턴한다.
//				data = fis.read();
//				// data가 -1이면 더 읽을게 없다.
//				if (data == -1) {
//					flag = false;
//				} else {
//					// int로 받았으니까 char로 형변환
////					System.out.println((char)data);
//				}
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {}
		}
	}
}
