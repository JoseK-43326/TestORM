package com.JoseK.TestDAO;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateFrame extends JFrame{
		
	private static final long serialVersionUID = 1L;
	private static UserDAO userDao = new UserDAOImplement();
	private JTextField nameField;
	private JTextField salaryField;
	private JTextField dateField;
	private JButton addButton;
	private JTextArea showText;
	public CreateFrame(){
		//设置frame属性
		setTitle("添 加");
		setSize(400,300);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:/java/Image/Doc.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UserAPP.mainFrame.setVisible(true);
			}			
		});
		//添加相应的组件
		JPanel buttonPanel = new JPanel();
		nameField = new JTextField(7);
		salaryField = new JTextField(7);
		dateField = new JTextField(7);
		addButton = new JButton("添 加");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String namaString = nameField.getText();
				String salaryString = salaryField.getText();
				double salary = Double.parseDouble(salaryString);
				String dateString = dateField.getText();
				Date date = DateFormatUtil.strToDate(dateString);
				userDao.create(namaString, salary, date);
				showText.append("数据插入成功！！"+"\r\n");
				//showText.append("插入的数据信息：");	//暂时解决不了			
			}
		});
		buttonPanel.add(nameField);
		buttonPanel.add(salaryField);
		buttonPanel.add(dateField);
		buttonPanel.add(addButton);
		add(buttonPanel,BorderLayout.NORTH);
		showText = new JTextArea();
		showText.setLineWrap(true);
		showText.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(showText);
		add(scrollPane,BorderLayout.CENTER);
	}
	
}
