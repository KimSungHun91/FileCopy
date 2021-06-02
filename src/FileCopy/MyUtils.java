package FileCopy;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

public class MyUtils {
	private static final Dimension TF_SIZE = new Dimension(220, 20);
	private static final Dimension BTN_SIZE = new Dimension(60, 25);

	public static JButton getButton(String str) {
		JButton btn = new JButton(str);
		btn.setPreferredSize(BTN_SIZE);
		return btn;
	}

	public static JTextField getTextField() {
		JTextField tf = new JTextField();
		tf.setPreferredSize(TF_SIZE);
		tf.setEditable(false);
		tf.setBorder(new LineBorder(Color.GRAY, 1));
		return tf;
	}

	public static boolean isEmpty(JTextComponent input) {
		String text = input.getText().trim();
		return (text.length() == 0) ? true : false;
	}
}