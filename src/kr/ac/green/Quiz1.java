package kr.ac.green;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Quiz1 {
	
	public static void fileCopy(String src, String copy) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(copy);
			
			int data = -1;
			while ((data = fis.read()) != -1) {
				// 1byte씩 쓰기.. 엄청 느림
				fos.write(data);
			}
			System.out.println("복사완료");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void newFileCopy(String src, String copy) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		long time = System.currentTimeMillis();
		
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(copy);
			
			// 크기가 9600인 byte배열을 생성한다.
			byte[] buf = new byte[9600];
			// 읽은 byte 수를 담을 변수.
			int count = -1;
			
			// 읽은 내용을 파라미터로 들어온 배열(buf)에 담는다, 그리고 count(읽은 byte 수)에 담는다.
			while ((count = fis.read(buf)) != -1) {
				// buf안의 내용을 쓰는데 0부터 count(읽은 byte 수)까지
				fos.write(buf, 0, count);
			}
			time = System.currentTimeMillis() - time;
			System.out.println("복사완료 : " + time + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e2) {}
			try {
				fos.close();
			} catch (Exception e2) {}
		}
	}
	
	
	public static void main(String[] args) {
//		fileCopy("c:\\doo\\mars.zip", "c:\\doo\\mars_copy.zip");
		newFileCopy("c:\\doo\\mars.zip", "c:\\doo\\mars_copy.zip");
		
	}
}
