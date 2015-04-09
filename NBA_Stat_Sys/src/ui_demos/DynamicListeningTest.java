package ui_demos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;  
import javax.swing.JTextField;  
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;  
import javax.swing.event.*;

public class DynamicListeningTest extends JFrame implements DocumentListener,FocusListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		DynamicListeningTest test = new DynamicListeningTest();
		System.out.println(test.getHeight());
	}
	
	private JTextField textfield1;
	
	JLabel feedbackLabel1;
	public DynamicListeningTest(){
		super("动态实现监听textfield");
		textfield1 = new JTextField();
		textfield1.addFocusListener(this);
		Document doc = textfield1.getDocument();
		doc.addDocumentListener(this);
		
		JFrame jf = new JFrame();
		jf.setLayout(new GridLayout(4,3,55,2));
//		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		JTextField jtf3 = new JTextField();
		String feedbackStr1 = new String("?");
		String feedbackStr2 = new String("?");
		String feedbackStr3 = new String("?");
		feedbackLabel1 = new JLabel(feedbackStr1);
		JLabel feedbackLabel2 = new JLabel(feedbackStr2);
		JLabel feedbackLabel3 = new JLabel(feedbackStr3);

		JButton jb = new JButton("提交");
		
		jf.add(new JLabel("Name (len(1~10)间小写英文)"));
		jf.add(textfield1);
		jf.add(feedbackLabel1);
		
		jf.add(new JLabel("Age (1~150之间)"));
		jf.add(jtf2);
		jf.add(feedbackLabel2);
		
		jf.add(new JLabel("Password (大于等于6位)"));
		jf.add(jtf3);
		jf.add(feedbackLabel3);
		
		jf.add(new JLabel());
		jf.add(jb);
		
		jf.setSize(650,150);
		jf.setLocale(null);
		jf.setVisible(true);
		
//		com.sun.awt.AWTUtilities.setWindowOpaque(jf,0.3f);
	}
	
	public void checkStr1(String s){
		if(s.length() > 0){
			feedbackLabel1.setText("正在输入...");
			for(int i = 0; i < s.length(); i ++){
				if(s.charAt(i) < 'a' || s.charAt(i) > 'z'){
					feedbackLabel1.setText("存在除小写字母的非法输入!");
				}
			}
		}
		if(s.length() > 10){
			feedbackLabel1.setText("长度不能超过10!");
		}
		if(s.length() == 0){
			feedbackLabel1.setText("?");
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		try {
			String s = doc.getText(0, doc.getLength());
			System.out.println("insert is: " + s);
			checkStr1(s);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		try {
			String s = doc.getText(0, doc.getLength());
			System.out.println("remove is: " + s);
			checkStr1(s);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		try {
			String s = doc.getText(0, doc.getLength());
			System.out.println("update is: " + s);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("textfield1 focus get!");
	}

	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("textfield1 focus lost!");
		if(feedbackLabel1.getText().equals("正在输入...")){
			feedbackLabel1.setText("ok!");
		}
	}

}
