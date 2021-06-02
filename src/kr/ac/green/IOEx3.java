package kr.ac.green;

import java.io.FileInputStream;
import java.io.IOException;

public class IOEx3 {
	public static void main(String[] args) {
		// JDK 1.7~, 자원해제가 필요한 것들을 try()안에 넣어주면 자동으로 해제한다.
		// AutoCloseble을 implements하는 클래스면 try()안에 넣을 수 있다.
		// 사용을 권장하진 않음, 버전..
		try (FileInputStream fis = new FileInputStream("test.txt")) {
			int data = -1;
			while ((data = fis.read()) != -1) {
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} // finally 없음
	}
}
