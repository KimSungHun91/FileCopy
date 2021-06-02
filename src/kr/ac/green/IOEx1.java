package kr.ac.green;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Output, 쓰기
public class IOEx1 {
	public static void main(String[] args) {
		// 파일을 byte단위로 쓰기 해보자...
		// finally 블록에서 쓸려고 null 초기화, 안하면 널포인트 뜸
		FileOutputStream fos = null;

		// IOEx1.java 파일이 있는 현재 경로
		try {
			// 만들기
			// default : 덮어 쓰기(over-write)
			// append option : 연속 쓰기
			fos = new FileOutputStream("test.txt"); // FileOutputStream(File file,boolean append)
			// 쓰기
			fos.write('t');
			fos.write('e');
			fos.write('s');
			fos.write('t');
			/*
			 * 한글은 깨진다.. byte로는 표현불가능
			 * '가' 등..
			 */
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					// 닫기
					fos.close();
				} catch (IOException e) {}
			}
		}
	}
}
