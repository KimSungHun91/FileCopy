package kr.ac.green;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Output, ����
public class IOEx1 {
	public static void main(String[] args) {
		// ������ byte������ ���� �غ���...
		// finally ��Ͽ��� ������ null �ʱ�ȭ, ���ϸ� ������Ʈ ��
		FileOutputStream fos = null;

		// IOEx1.java ������ �ִ� ���� ���
		try {
			// �����
			// default : ���� ����(over-write)
			// append option : ���� ����
			fos = new FileOutputStream("test.txt"); // FileOutputStream(File file,boolean append)
			// ����
			fos.write('t');
			fos.write('e');
			fos.write('s');
			fos.write('t');
			/*
			 * �ѱ��� ������.. byte�δ� ǥ���Ұ���
			 * '��' ��..
			 */
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					// �ݱ�
					fos.close();
				} catch (IOException e) {}
			}
		}
	}
}
