package kr.ac.green;

import java.io.File;

import javax.swing.JFileChooser;

public class IOEx5 {
	
	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser("c:"); // param : ������ ��ġ, . �� ������ġ
		
		// ����
		int open = chooser.showOpenDialog(null);
		
		int save = chooser.showSaveDialog(null);
		
		// ������ �����ϰ� ���� ���� ����
		if (open == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
		}
		// ������ �����ϰ� ���� ���� ����
		if (save == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
		}
	}
}
