package com.JoseK.TestDAO;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SeekFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private static UserDAO userDao = new UserDAOImplement();
	private JTextField inputId;
	private JButton seekButton;
	private JTextArea showText;	
	
	public SeekFrame(){
		//frame框架属性设置
		setTitle("查 询");
		setSize(400, 300);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:/java/Image/Doc.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UserAPP.mainFrame.setVisible(true);
			}
		});
		//North -----添加相应的textField 和 button按钮
		JPanel buttonPanel = new JPanel();
		inputId = new JTextField(10);
		inputId.addFocusListener(new JTextFieldHintListener("输入数字id", inputId));
		seekButton = new JButton("查询");
		seekButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idString = inputId.getText();
				int id = Integer.parseInt(idString);
				User user = userDao.read(id);
				showText.append("Name:"+user.getName()+"--"+
									"Salary:"+user.getSalary()+"--"+
									"HireDate:"+user.getHireDate()+"\r\n");
			}
		});
		buttonPanel.add(inputId);
		buttonPanel.add(seekButton);
		add(buttonPanel,BorderLayout.NORTH);
		//Center -----添加信息显示的 TextArea
		showText = new JTextArea();
		showText.setEditable(false);
		showText.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(showText);
		add(scrollPane,BorderLayout.CENTER);			
	}

}
