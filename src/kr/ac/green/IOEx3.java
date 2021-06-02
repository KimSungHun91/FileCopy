package kr.ac.green;

import java.io.FileInputStream;
import java.io.IOException;

public class IOEx3 {
	public static void main(String[] args) {
		// JDK 1.7~, �ڿ������� �ʿ��� �͵��� try()�ȿ� �־��ָ� �ڵ����� �����Ѵ�.
		// AutoCloseble�� implements�ϴ� Ŭ������ try()�ȿ� ���� �� �ִ�.
		// ����� �������� ����, ����..
		try (FileInputStream fis = new FileInputStream("test.txt")) {
			int data = -1;
			while ((data = fis.read()) != -1) {
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} // finally ����
	}
}
