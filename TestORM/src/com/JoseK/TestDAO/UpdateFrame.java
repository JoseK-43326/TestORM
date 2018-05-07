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

public class UpdateFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private static UserDAO userDAO = new UserDAOImplement();
	private JTextField idField;
	private JTextField nameField;
	private JTextField salaryField;
	private JTextField dateField;
	private JTextArea showText;
	private JButton updateButton;
	public UpdateFrame() {
		//设置frame属性
		setTitle("修 改");
		setSize(400,300);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:/java/Image/Doc.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UserAPP.mainFrame.setVisible(true);
			}
		});
		//添加组件
		JPanel buttonPanel = new JPanel();
		idField = new JTextField(2);		
		nameField = new JTextField(8);		
		salaryField = new JTextField(8);		
		dateField = new JTextField(8);		
		updateButton = new JButton("修 改");
		updateButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idString = idField.getText();
				int id = Integer.parseInt(idString);
				String nameString = nameField.getText();
				String salaryString = salaryField.getText();
				double salary = Double.parseDouble(salaryString);
				String dateString = dateField.getText();
				Date date = DateFormatUtil.strToDate(dateString);
				userDAO.update(nameString, salary, date, id);
				User user = userDAO.read(id);
				showText.append("修改数据成功！！"+"\r\n");
				showText.append("修改后的信息："+"\r\n"+
								"Name:"+user.getName()+"--"+
								"Salary:"+user.getSalary()+"--"+
								"HireDate:"+user.getHireDate()+"\r\n");
			}
		});
		buttonPanel.add(idField);
		buttonPanel.add(nameField);
		buttonPanel.add(salaryField);
		buttonPanel.add(dateField);
		buttonPanel.add(updateButton);
		add(buttonPanel,BorderLayout.NORTH);
		showText = new JTextArea();
		showText.setLineWrap(true);
		showText.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(showText);
		add(scrollPane,BorderLayout.CENTER);		
	}
	
	
	
	
	
}	
