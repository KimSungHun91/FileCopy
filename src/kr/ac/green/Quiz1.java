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
				// 1byte�� ����.. ��û ����
				fos.write(data);
			}
			System.out.println("����Ϸ�");
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
			
			// ũ�Ⱑ 9600�� byte�迭�� �����Ѵ�.
			byte[] buf = new byte[9600];
			// ���� byte ���� ���� ����.
			int count = -1;
			
			// ���� ������ �Ķ���ͷ� ���� �迭(buf)�� ��´�, �׸��� count(���� byte ��)�� ��´�.
			while ((count = fis.read(buf)) != -1) {
				// buf���� ������ ���µ� 0���� count(���� byte ��)����
				fos.write(buf, 0, count);
			}
			time = System.currentTimeMillis() - time;
			System.out.println("����Ϸ� : " + time + "ms");
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
