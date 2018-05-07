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

public class DeleteFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static UserDAO userDao = new UserDAOImplement();
	private JButton deleteButton;
	private JTextField inputId;
	private JTextArea showText;
	public DeleteFrame() {
		
		setTitle("删 除");
		setSize(400, 300);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:/java/Image/Doc.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UserAPP.mainFrame.setVisible(true);
			}
		});
		JPanel buttonPanel = new JPanel();
		inputId = new JTextField(10);
		inputId.addFocusListener(new JTextFieldHintListener("输入数字id", inputId));
		deleteButton = new JButton("删 除");
		deleteButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idString = inputId.getText();
				int id = Integer.parseInt(idString);
				User user = userDao.read(id);				
				showText.append("ID为"+id+"的数据已删除"+"\r\n");
				showText.append("删除内容为："+"Name:"+user.getName()+"--"+
									"Salary:"+user.getSalary()+"--"+
									"HireDate:"+user.getHireDate()+"\r\n");
				userDao.delete(id);
			}
		});
		buttonPanel.add(inputId);
		buttonPanel.add(deleteButton);
		add(buttonPanel,BorderLayout.NORTH);
		showText = new JTextArea();
		showText.setEditable(false);
		showText.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(showText);
		add(scrollPane,BorderLayout.CENTER);
		
	}
	
}
