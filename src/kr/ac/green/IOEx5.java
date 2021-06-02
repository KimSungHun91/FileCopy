package kr.ac.green;

import java.io.File;

import javax.swing.JFileChooser;

public class IOEx5 {
	
	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser("c:"); // param : 시작할 위치, . 은 현재위치
		
		// 열기
		int open = chooser.showOpenDialog(null);
		
		int save = chooser.showSaveDialog(null);
		
		// 파일을 선택하고 열기 누른 상태
		if (open == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
		}
		// 파일을 선택하고 저장 누른 상태
		if (save == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
		}
	}
}
