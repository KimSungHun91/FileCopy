package FileCopy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FileCopy extends JFrame {
	private JTextField tfSrcInfo;
	private JTextField tfCopyInfo;
	private JTextField tfBuf;

	private JButton btnSelectSrc;
	private JButton btnSelectCopy;
	private JButton btnCopy;

	private JTextArea taResult;

	private File scrFile;
	private File copyFile;

	private String src;
	private String copy;

	private long time;

	public FileCopy() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void init() {
		tfSrcInfo = MyUtils.getTextField();
		tfCopyInfo = MyUtils.getTextField();
		tfBuf = new JTextField(25);
		tfBuf.setHorizontalAlignment(JTextField.CENTER);

		btnSelectSrc = MyUtils.getButton("선택");
		btnSelectCopy = MyUtils.getButton("선택");
		btnCopy = MyUtils.getButton("복사");

		taResult = new JTextArea(10, 25);
		taResult.setEditable(false);
	}

	private void setDisplay() {
		LineBorder lBorder = new LineBorder(Color.GRAY, 1);

		JPanel pnlNorth = new JPanel(new GridLayout(0, 1));
		JPanel pnlSrcInfo = new JPanel();
		pnlSrcInfo.add(tfSrcInfo);
		pnlSrcInfo.add(btnSelectSrc);
		pnlSrcInfo.setBorder(new TitledBorder(lBorder, "원본정보"));
		JPanel pnlCopyInfo = new JPanel();
		pnlCopyInfo.add(tfCopyInfo);
		pnlCopyInfo.add(btnSelectCopy);
		pnlCopyInfo.setBorder(new TitledBorder(lBorder, "복사본정보"));
		JPanel pnlTfBuf = new JPanel();
		pnlTfBuf.add(tfBuf);
		pnlTfBuf.setBorder(new TitledBorder(lBorder, "버퍼크기"));
		pnlNorth.add(pnlSrcInfo);
		pnlNorth.add(pnlCopyInfo);
		pnlNorth.add(pnlTfBuf);

		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnCopy);

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(taResult);
		pnlSouth.setBorder(new TitledBorder(lBorder, "실행결과"));

		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void addListeners() {
		JFileChooser chooser = new JFileChooser("c:");

		btnSelectSrc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int open = chooser.showOpenDialog(null);
				if (open == JFileChooser.APPROVE_OPTION) {
					scrFile = chooser.getSelectedFile();
					try {
						src = scrFile.getCanonicalPath();
						tfSrcInfo.setText(src);
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});

		btnSelectCopy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int save = chooser.showSaveDialog(null);
				if (save == JFileChooser.APPROVE_OPTION) {
					copyFile = chooser.getSelectedFile();
					try {
						copy = copyFile.getCanonicalPath();
						tfCopyInfo.setText(copy);
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});

		btnCopy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MyUtils.isEmpty(tfSrcInfo)) {
					JOptionPane.showMessageDialog(null, "원본정보를 선택하세요.");
				} else if (MyUtils.isEmpty(tfCopyInfo)) {
					JOptionPane.showMessageDialog(null, "복사본정보를 선택하세요.");
				} else if (MyUtils.isEmpty(tfBuf)) {
					JOptionPane.showMessageDialog(null, "버퍼크기를 입력하세요.");
				} else {
					FileInputStream fis = null;
					FileOutputStream fos = null;
					time = System.currentTimeMillis();
					
					try {
						fis = new FileInputStream(src);
						fos = new FileOutputStream(copy);
						
						int input = Integer.parseInt(tfBuf.getText());
						byte[] buf = new byte[input];
						int count = -1;
						
						while ((count = fis.read(buf)) != -1) {
							fos.write(buf, 0, count);
						}
						time = System.currentTimeMillis() - time;
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						try {
							fis.close();
						} catch (Exception e3) {
						}
						try {
							fos.close();
						} catch (Exception e3) {
						}
					}
					showResult();
				}
			}
		});
	}

	private void showResult() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(a hh:mm:ss)");
		Date date = new Date();
		date.setTime(copyFile.lastModified());

		String info = "- 작업정보 -\n";
		info += "- 작업일시 : " + sdf.format(date) + "\n";
		info += "- 원본파일 : " + scrFile.getPath() + "\n";
		info += "- 복사본파일 : " + copyFile.getPath() + "\n";
		info += "- 파일 크기 : " + scrFile.length() + "byte\n";
		info += "- 소요시간 : " + time + "ms";

		taResult.setText(info);
	}

	private void showFrame() {
		setTitle("파일복사");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FileCopy();
	}
}
