package kr.ac.green;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Input, �б�
public class IOEx2 {
	public static void main(String[] args) {
		// finally ��Ͽ��� ������ null �ʱ�ȭ, ���ϸ� ������Ʈ ��
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("test.txt");
			// �о�� �����͸� ���� ����, -1�� ��
			int data = -1; 
			
			// 1. �Ʒ� �ڵ�� ����, ���� ��
			while ((data = fis.read()) != -1) {
				System.out.println((char)data);
			}
			
//			// 2. Ǯ���
//			boolean flag = true;
//			while (flag) {
//				// read()�� ���������� char���� �����Ѵ�.
//				data = fis.read();
//				// data�� -1�̸� �� ������ ����.
//				if (data == -1) {
//					flag = false;
//				} else {
//					// int�� �޾����ϱ� char�� ����ȯ
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
